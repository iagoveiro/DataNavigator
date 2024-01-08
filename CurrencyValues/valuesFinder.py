import re
from colorama import Fore
import requests
from bs4 import BeautifulSoup

site = "https://www.investing.com/currencies/"
result = requests.get(site)
content = result.text


soup = BeautifulSoup(content, 'html.parser')

# Diccionario de los identificadores de las monedas
currency_ids = {
    'Euro               ': 'pid-1-last',
    'British Pound      ': 'pid-2-last',
    'Japanese Yen       ': 'pid-3-last',
    'Swiss Franc        ': 'pid-4-last',
    'Australian Dollar  ': 'pid-5-last',
    'Canadian Dollar    ': 'pid-7-last',
    'New Zelland Dollar ': 'pid-8-last'
}

# Diccionario para almacenar los valores de las monedas
currency_values = {}

for currency_name, currency_id in currency_ids.items():
    currency_value = soup.find('td', class_=currency_id).text  
    currency_values[currency_name] = float(currency_value)  

# Imprime los valores de las monedas
for currency_name, value in currency_values.items():
    print(f'{currency_name}: {value}')