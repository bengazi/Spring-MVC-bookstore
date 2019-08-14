insert into user_role(role, description) VALUES ("ROLE_USER", "default role for user");

INSERT INTO book ( author, price, publisher, book_title, book_type, picture_source) VALUES ( "Gniewomir Sarbicki", 54.50, "Helion", "Python. Kurs dla nauczycieli i studentow", "Informatyka", "pythonkursdlanauczycieli");
INSERT INTO book ( author, price, publisher, book_title, book_type, picture_source) VALUES ( "Robert C. Martin", 60.99, "Helion", "Czysty kod. Podrecznik dobrego programisty", "Informatyka", "czystykod");
INSERT INTO book ( author, price, publisher, book_title, book_type, picture_source) VALUES ( "Lackberg Camilla", 27.99, "Czarna Owca", "Zlota klatka", "kryminal", "zlotaklatka");
INSERT INTO book ( author, price, publisher, book_title, book_type, picture_source) VALUES ( "Paris B.A.", 24.99, "Albatros", "Pozwol mi wrocic", "thriller", "pozwolmiwrocic");
INSERT INTO book ( author, price, publisher, book_title, book_type, picture_source) VALUES ( "Lipinska Blanka", 29.99, "Edipresse", "Ten dzien", "Literatura obyczajowa", "tendzien");
INSERT INTO book ( author, price, publisher, book_title, book_type, picture_source) VALUES ( "Obama Michelle", 31.49, "Agora", "Becoming. Moja historia", "Biografia", "becoming-moja-historia");
INSERT INTO book ( author, price, publisher, book_title, book_type, picture_source) VALUES ( "author4Krzysztof Gonciarz", 40.99, "KG Tofu Media", "Wybuchajace Beczki - zrozumiec gry wideo", "Informatyka", "wybuchajacebeczki");
INSERT INTO book ( author, price, publisher, book_title, book_type, picture_source) VALUES ( "J.K. Rowling", 20.99, "Media Rodzina", "Harry Potter i Komnata Tajemnic", "Fantastyka", "komnatatajemnic");
INSERT INTO book ( author, price, publisher, book_title, book_type, picture_source) VALUES ( "J.K. Rowling", 20.99, "Media Rodzina", "Harry Potter i Zakon Feniksa", "Fantastyka", "zakonfeniksa");
INSERT INTO book ( author, price, publisher, book_title, book_type, picture_source) VALUES ( "J.R.R. Tolkien", 30.99, "Amber", "Wladca Pierscieni", "Fantastyka", "wladcapierscieni");
INSERT INTO book ( author, price, publisher, book_title, book_type, picture_source) VALUES ( "J.R.R. Tolkien", 30.99, "Amber", "Silmarillion", "Fantastyka", "silmarillion");

INSERT INTO user(address,email,firstname,lastname,password,username)VALUES("adres1","email@test.pl","Marek","Testcieja","{bcrypt}$2a$10$odJqe1dJkq/dXMTfY2p.cuoNKy5OGund5ILP1gaNM9CVRf6x7Ol6y","1");