import json
import datetime
#Defining the rules of thr discount by creating a dictionary
discount_rules ={
    "online": {
        "accessories":{
            "new_user": {
                "discount":10,
                "days_valid":30
            },
            "existing_user": {
                "discount" : 10
            },
            "default": {
                "discount":0
            }
        },
        "clothes": {
            "over_150": {
                "discount":10
            },
            "default": {
                "discount":0
            }
        },
        "men": {
            "active_wear" :{
                "discount" : 15
            },
            "default": {
                "discount": 0
            }
        },
        "kids" :{
            "default": {
                "discount": 0
            }        }

    },
    "instore": {
        "accessories": {
            "over_100":  {
                "discount":10
            },
            "default": {
                "discount": 0
            }        },
        "clothes": {
            "over_250":  {
                "discount":10
            },
            "default": {
                "discount": 0
            }
        },
        "women" : {
            "over_250" :  {
                "discount":10
            },
            "default": {
                "discount": 0
            }
        },
        "kids" :{
            "default": {
                "discount": 0
            }
        },

    }
}

#Defining the rules for the cash back

cash_back_rules ={
    "online" :0.10,
    "instore": 0.10
}

#item specifics
item_discounts ={
    "accessories": {
        "bags": ['Chanel','Louis Vuitton','CK']

    },

    "clothes":{
        "suits" : ['Armani','Balenciaga']
    }
}


#check discount eligibility

def is_eligible(item_type,item_name):
    if item_type == "accessories":
        if item_name in item_discounts[item_type]["bags"]:
            return False
        elif item_type == "clothes":
            if item_name in item_discounts[item_type]["suits"]:
                return False
    return True


#the function to calculate the discount
def calculate(client_type,item_type,price):
    #client
    discount_rule = discount_rules[client_type].get(item_type)
    if discount_rule:
        if isinstance(discount_rule,dict):
            if price >= 150 and "over_150" in discount_rule:
                return discount_rule["over_150"]["discount"]
            else:
                return discount_rule.get("default", {}).get("discount",0)
        else:
            return discount_rule["discount"]
    return 0


#calculating the cash back
def calculate_cb(client_type,total_price):
    #get the cb rules
    cash_back_rule = cash_back_rules.get(client_type, 0)


    #calculating
    cash_back = total_price * cash_back_rule

    #returning
    return  cash_back


#current date
current_date = datetime.datetime.now()


#USER INPUT FROM HERE

client_type = input("Enter the client type (online/instore):  ")
item_type = input("Enter the item type (women/mens/kids/accessories):  ")
item_name = input("Enter the name of the item: ")
price = float(input("Enter the price: "))

#new user verification

if  client_type == "online":
    user_type = input("Are you a new user(Yes/No)?: ")
    if user_type.lower() =="yes":
        discount_type = "new_user"
        discount_end = current_date + datetime.timedelta(days=discount_rules[client_type][item_type][discount_type]["days_valid"])
        if current_date <= discount_end:
            discount = discount_rules[client_type][item_type]["default"]["discount"]
        else:
            discount = discount_rules[client_type][item_type]["existing_user"]["discount"]
    else:
        discount = calculate(client_type,item_type,price)

# eligibility check

if not is_eligible(item_type,item_name):
    discount =0


#Calculating the total price
total_price = price - (price * discount /100)

#Calculating the Cash back
cash_back = calculate_cb(client_type, total_price)

#printing the result
print("The discount is $%.2f" % discount)
print("The total price is $%.2f" % total_price)
print("The cash back is $%.2f" % cash_back)


