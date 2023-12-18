import database

# database.add_one('blue', 'Color', 'blue@dot.com')
# database.delete_one(4)
# database.show_all()

many_customers = [
    ('Orange', 'Color', 'orange@dot.com'),
    ('Pink', 'Color', 'pink@dot.com'),
    ('Green', 'Color', 'green@dot.com'),
]

# database.add_many(many_elements=many_customers)
# database.delete_one(4)
database.show_all()