(* Dan Grossman, Coursera PL, HW2 Provided Code *)

(* if you use this function to compare two strings (returns true if the same
   string), then you avoid several of the functions in problem 1 having
   polymorphic types that may be confusing *)
fun same_string(s1 : string, s2 : string) =
    s1 = s2

(* put your solutions for problem 1 here *)

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
                | l::list' => get_sub_helper(list', acc, @ extract_list_val(all_except_option(s, 1)))
    in
        get_sub_helper(listm s, [])
    end










(* you may assume that Num is always used with values 2, 3, ..., 10
   though it will not really come up *)
datatype suit = Clubs | Diamonds | Hearts | Spades
datatype rank = Jack | Queen | King | Ace | Num of int 
type card = suit * rank

datatype color = Red | Black
datatype move = Discard of card | Draw 

exception IllegalMove

(* put your solutions for problem 2 here *)