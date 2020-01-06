
def inferior_twenty(number):
    nb = ""
    if number == 0:
        nb = "zero"
    elif number == 1:
        nb = "one"
    elif number == 2:
        nb = "two"
    elif number == 3:
        nb = "three"
    elif number == 4:
        nb = "four"
    elif number == 5:
        nb = "five"
    elif number == 6:
        nb = "six"
    elif number == 7:
        nb = "seven"
    elif number == 8:
        nb = "eight"
    elif number == 9:
        nb = "nine"
    elif number == 10:
        nb = "ten"
    elif number == 11:
        nb = "eleven"
    elif number == 12:
        nb = "twelve"
    elif number == 13:
        nb = "thirteen"
    elif number == 14:
        nb = "fourteen"
    elif number == 15:
        nb = "fifteen"
    elif number == 16:
        nb = "sixteen"
    elif number == 17:
        nb = "seventeen"
    elif number == 18:
        nb = "eighteen"
    elif number == 19:
        nb = "nineteen"
    else:
        exit

    return nb

def inferior_hundred(number):
    mod, hundred, nb = 0, 0, ""

    if number < 20:
        nb = inferior_twenty(number)
    elif number < 30:
        mod = number % 10
        if mod == 0:
            nb = "twenty"
        elif mod == 1:
            nb = "twenty " + inferior_twenty(mod)
    elif number < 40:
        mod = number % 10
        if mod == 0:
            nb = "thirty"
        else:
            nb = "thirty " + inferior_twenty(mod) 
    elif number < 50:
        mod = number % 10
        if mod == 0:
            nb = "fourty"
        else:
            nb = "fourty " + inferior_twenty(mod) 
    elif number < 60:
        mod = number % 10
        if mod == 0:
            nb = "fifty"
        else:
            nb = "fifty " + inferior_twenty(mod) 
    elif number < 70:
        mod = number % 10
        if mod == 0:
            nb = "sixty"
        else:
            nb = "sixty " + inferior_twenty(mod) 
    elif number < 80:
        mod = number % 10
        if mod == 0:
            nb = "seventy"
        else:
            nb = "seventy " + inferior_twenty(mod) 
    elif number < 90:
        mod = number % 10
        if mod == 0:
            nb = "eigthy"
        else:
            nb = "eigthy " + inferior_twenty(mod) 
    elif number < 100:
        mod = number % 10
        if mod == 0:
            nb = "ninety"
        else:
            nb = "ninety " + inferior_twenty(mod) 

    return nb


def inferior_thousand(number):
    nb, centain, cent =  "", 0, 0
    
    if number < 100:
        nb = inferior_hundred(number)
    elif number < 1000:
        centain = number % 100
        cent = number / 100
        if cent == 1:
            if centain == 0:
                nb = "one hundred"
            else:
                nb = "one hundred " + inferior_hundred(number)
        else:
            if centain == 0:
                nb = inferior_hundred(cent) + " hundred"
            else:
                nb = inferior_hundred(cent) + " hundred " + inferior_hundred(centain)

    return nb

def inferior_one_million(number):
    nb, thousandth, miles =  "", 0, 0

    if number < 1000:
        nb = inferior_thousand(number)
    else:
        thousandth = number % 1000
        miles = number / 1000
        if miles == 1:
            if thousandth == 0:
                nb = "thousand"
            else:
                nb = "one thousand " + inferior_thousand(thousandth)
        elif miles < 1000:
            if thousandth == 0:
                nb = inferior_thousand(miles) + " thousand"
            else:
                nb = inferior_thousand(miles) + " thousand " + inferior_thousand(thousandth)

    return nb



def inferior_one_billion(number):
    nb, millionth, million = "", 0, 0

    if number < 1000000:
        nb = inferior_one_million(number)
    elif number < 1000000000:
        million = number % 1000000
        millionth = number / 1000000
        if millionth == 1:
            if million == 0:
                nb = inferior_one_million(millionth) + " million"
            else:
                nb = inferior_one_million(millionth) + " million " + inferior_one_million(million)
        else:
            if million == 0:
                nb = inferior_one_million(millionth) + " millions"
            else:
                nb = inferior_one_million(millionth) + " millions " + inferior_one_million(million)
    return nb

# number = input("> Type a number between 0 - 1 000 000 000 : ")
# while number != 00:
#     number = int(number)
    
#     if number < 100:
#         print(inferior_hundred(number).capitalize())
#     elif number < 1000:
#         print(inferior_thousand(number).capitalize())
#     elif number < 1000000:
#         print(inferior_one_million(number).capitalize())
#     elif number < 1000000000:
#         print(inferior_one_billion(number).capitalize())
#     elif number == 1000000000:
#         print("> One billion")

#     print("Type '00' to quit...")
#     number = input("> Type a number between 0 - 1 000 000 000 : ")
    
# print("Thanks !")



def modulo(number):
    mod, num = 0, 0
    mod = number % 10
    numbers = [ 
        [10, 'ten'], 
        [20, 'twenty'], 
        [30, 'thirty'], 
        [40, 'fourty'], 
        [50, 'fifty'], 
        [60, 'sixty'], 
        [70, 'seventy'], 
        [80, 'eighty'], 
        [90, 'ninety'], 
    ]

    if mod == 0 :
        for i, nb in enumerate(numbers):
            if nb[0] == number:
                num = nb[1]
    else:
        for i, nb in enumerate(numbers):
            if nb[0] == number:
                num = nb[1] + " " + str(inferior_twenty(mod))
    return num 

print(modulo(89))