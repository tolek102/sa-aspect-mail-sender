# Akademia springa - moduł 6

## Wysyłka maila z użyciem aspektu

### Zadanie

Napisz aplikację, która będzie udostępniała prosty interfejs API. Każdy kto odwoła się do metody GET otrzyma listę filmów (nazwa, rok producent). Natomiast odwołanie się do metody POST, która umożliwia na dodawanie filmu do listy, a dodatkowo spowoduje WYSŁANIE MAILA z wykorzystaniem ASPEKU.

To jak wysłać maila poprzez mechanizm dostarczony przez Spring jest Twoją pracą domową, która wymaga od Ciebie researchu.

Pamiętaj, że wysyłka maila ma odbywać się z wykorzystaniem aspektu! Zastosuj odpowiednia poradę po dodaniu nowego elementu do listy.

### W projekcie użyto:

* maven 3.6.3
* java11
* springboot 2.6.3
* lombook
* Thymeleaf
* html
* css

### Info
Proste gui do obsługi Api

http://localhost:8080/movies

Klient pocztowy jest skonfigurowany pod konto gmail.com
należy uzupełnić w konfiguracji własnymi danymi:

adres email:   
spring.mail.username=<login user to smtp server>

hasło:   
(jeśli kożystamy z dwuetapowej weryfikacji na koncie to trzeba wygenerować hasło aplikacji)
instrukcja: https://support.google.com/accounts/answer/185833   
spring.mail.password=<login password to smtp server>

imię odbiorcy maila:   
example.logged.user.context.data.name=Pawel

email odbiorcy maila:   
example.logged.user.context.data.email=pawel.mail@server.com