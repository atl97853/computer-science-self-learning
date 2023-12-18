import sqlite3

# Query The DB and Return All Records 

def show_all():
    # Connect to data base and create a cursor 
    conn = sqlite3.connect('customer.db')
    c = conn.cursor()

    # Query the Database 
    c.execute("SELECT rowid, * FROM customers")
    items = c.fetchall()

    # Format Results 
    for item in items:
        print(item)
    
    # Commit our command 
    conn.commit()
    # Close our connection
    conn.close()

# Add A New Record To The Table 
def add_one(first,last,email):
    # Connect to data base and create a cursor 
    conn = sqlite3.connect('customer.db')
    c = conn.cursor()
    c. execute("INSERT INTO customers VALUES (?,?,?)", (first, last, email))
    print('the element was sucessfully added...')
    # Commit our command 
    conn.commit()
    # Close our connection
    conn.close()

def delete_one(rowid):
    # Connect to data base and create a cursor 
    conn = sqlite3.connect('customer.db')
    c = conn.cursor()
    c. execute(f"DELETE from customers WHERE rowid = {rowid}")
    print('the element was sucessfully delted...')
    # Commit our command 
    conn.commit()
    # Close our connection
    conn.close()

def add_many(list):
    # Connect to data base and create a cursor 
    conn = sqlite3.connect('customer.db')
    c = conn.cursor()
    c.executemany("INSERT INTO customers VALUES (?,?,?)", list)
    print('the elements were sucessfully added...')
    # Commit our command 
    conn.commit()
    # Close our connection
    conn.close()