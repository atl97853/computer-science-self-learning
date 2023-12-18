(* Dan Grossman, Coursera PL, HW2 Provided Code *)

(* if you use this function to compare two strings (returns true if the same
   string), then you avoid several of the functions in problem 1 having
   polymorphic types that may be confusing *)
fun same_string(s1 : string, s2 : string) =
    s1 = s2

(* put your solutions for problem 1 here ------------------------------------------*)

(* (a) Write a function all_except_option, which takes a string and a string list. Return NONE if the
string is not in the list, else return SOME lst where lst is identical to the argument list except the string
is not in it. You may assume the string is in the list at most once. Use same_string, provided to you,
to compare strings. Sample solution is around 8 lines. *)
fun all_except_option (s, xs) = 
    case xs of
	[] => NONE
      | x::xs' => if same_string(x, s)
		  then SOME xs'
		  else case all_except_option(s, xs') of
			   NONE => NONE 
			 | SOME tail => SOME (x::tail)

(* (b) Write a function get_substitutions1, which takes a string list list (a list of list of strings, the
substitutions) and a string s and returns a string list. The result has all the strings that are in
some list in substitutions that also has s, but s itself should not be in the result. Example:
get_substitutions1([["Fred","Fredrick"],["Elizabeth","Betty"],["Freddie","Fred","F"]],
"Fred") *)
(* answer: ["Fredrick","Freddie","F"] *)
fun get_substitutions1 (list, s) =
  case list of
      [] => []
    | l::list' => case all_except_option(s, l) of
		    NONE => [] 
		   | SOME sublist => sublist @ get_substitutions1(list', s)

(* (c) Write a function get_substitutions2, which is like get_substitutions1 except it uses a tail-recursive
local helper function. *)
fun get_substitutions2 (list, s) =
  let
      fun extract_list_val(opt) =
	case opt of
	    NONE => []
	  | SOME sublist => sublist
      fun get_sub_helper(list, s, acc) =
	case list of
	    [] => acc
	  | l::list'=> get_sub_helper(list', s, acc @ extract_list_val(all_except_option(s, l)))
  in
      get_sub_helper(list, s, [])
  end

(* (d) Write a function similar_names, which takes a string list list of substitutions (as in parts (b) and
(c)) and a full name of type {first:string,middle:string,last:string} and returns a list of full
names (type {first:string,middle:string,last:string} list). The result is all the full names you
can produce by substituting for the first name (and only the first name) using substitutions and parts (b)
or (c). The answer should begin with the original name (then have 0 or more other names). Example:
similar_names([["Fred","Fredrick"],["Elizabeth","Betty"],["Freddie","Fred","F"]],
{first="Fred", middle="W", last="Smith"}) *)

fun similar_names (list, name) =
  let fun similar_helper(subs, name) =
	case subs of
	    [] => []
	  | sub::subs' => case name of
			      {first=x, last=y, middle=z} =>
			      [{first=sub, last=y, middle=z}] @ similar_helper(subs', name)
  in
      case name of
	  {first=x, middle=y, last=z} =>
	  let
	      val firstname_subs = get_substitutions2(list, x)
	  in
	      name::similar_helper(firstname_subs, name)
	  end
  end

(* Solitaire card game ----------------------------------------------------------------  *)
(* you may assume that Num is always used with values 2, 3, ..., 10
   though it will not really come up *)
datatype suit = Clubs | Diamonds | Hearts | Spades
datatype rank = Jack | Queen | King | Ace | Num of int 
type card = suit * rank

datatype color = Red | Black
datatype move = Discard of card | Draw 

exception IllegalMove

(* put your solutions for problem 2 here *)
(* (a) Write a function card_color, which takes a card and returns its color (spades and clubs are black,
diamonds and hearts are red). Note: One case-expression is enough *)
fun card_color (card) =
  case card of
      {1=Clubs,  2=_} => Black    
    | {1=Spades, 2=_} => Black
    | _ => Red

(* (b) Write a function card_value, which takes a card and returns its value (numbered cards have their
number as the value, aces are 11, everything else is 10). Note: One case-expression is enough. *)
fun card_value (card) =
  case card of
      {1=_ , 2=Num(int)} => int
    | {1=_ , 2=Ace} => 11
    | _ => 10

(* (c) Write a function remove_card, which takes a list of cards cs, a card c, and an exception e. It returns a
list that has all the elements of cs except c. If c is in the list more than once, remove only the first one.
If c is not in the list, raise the exception e. You can compare cards with = *)
fun remove_card (cards, c, e) =
  let fun remove_helper(cards, c, e, removed) =
	case cards of
	    [] => if removed
		  then []
		  else raise e
	  | card::cards' => if card = c andalso removed = false
			    then remove_helper(cards', c, e, true)
			    else card::remove_helper(cards', c, e, removed)
  in
      remove_helper(cards, c, e, false)
  end

(* (d) Write a function all_same_color, which takes a list of cards and returns true if all the cards in the
list are the same color. Hint: An elegant solution is very similar to one of the functions using nested
pattern-matching in the lectures *)
fun all_same_color (cards) =
  case cards of
      [] => true
    | card::[] => true
    | card1::card2::cards' => (card_color(card1) = card_color(card2)) andalso all_same_color(card2::cards')

(* (e) Write a function sum_cards, which takes a list of cards and returns the sum of their values. Use a locally
defined helper function that is tail recursive. (Take “calls use a constant amount of stack space” as a
requirement for this problem.) *)
fun sum_cards (cards) =
  let fun sum_helper(cards, acc) =
	case cards of
	    [] => acc
	  | card::cards' => sum_helper(cards', acc + card_value(card)) 
  in
      sum_helper(cards, 0)
  end

(* (f) Write a function score, which takes a card list (the held-cards) and an int (the goal) and computes
the score as described above. *)
fun score (cards, goal) =
  let
      val sum = sum_cards(cards)
      val prelim_score = if sum > goal
			 then 3 * (sum - goal)
			 else (goal - sum)
				  
  in
      if all_same_color(cards)
      then prelim_score div 2
      else prelim_score	       
  end

(* (g) Write a function officiate, which “runs a game.” It takes a card list (the card-list) a move list
(what the player “does” at each point), and an int (the goal) and returns the score at the end of the
game after processing (some or all of) the moves in the move list in order. Use a locally defined recursive
helper function that takes several arguments that together represent the current state of the game. As
described above:
• The game starts with the held-cards being the empty list.
• The game ends if there are no more moves. (The player chose to stop since the move list is empty.)
• If the player discards some card c, play continues (i.e., make a recursive call) with the held-cards
not having c and the card-list unchanged. If c is not in the held-cards, raise the IllegalMove
exception.
• If the player draws and the card-list is (already) empty, the game is over. Else if drawing causes
the sum of the held-cards to exceed the goal, the g *)
fun officiate (cards, moves, goal) =
  let
      fun play (held, goal, cards, moves) =
	if sum_cards(held) > goal
	then score(held, goal)
	else case moves of
		 [] => score(held, goal)
	       | move::moves' => case move of
				     Discard(card) => play(remove_card(held, card, IllegalMove), goal, cards, moves')
				   | Draw => case cards of
						 [] => score(held, goal)
					       | card::[] => play(card::held, goal, [], moves')
					       | card::cards' => play(card::held, goal, cards', moves')
							   
  in
      play([], goal, cards, moves)
  end   