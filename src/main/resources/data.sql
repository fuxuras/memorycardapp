INSERT INTO Card (front, back) VALUES
                                   ('Astonishing', 'Şaşırtıcı'),
                                   ('Consequence', 'Sonuç'),
                                   ('Vulnerable', 'Savunmasız'),
                                   ('Incredible', 'İnanılmaz'),
                                   ('Comprehensive', 'Kapsamlı'),
                                   ('Ambiguous', 'Belirsiz'),
                                   ('Cautiously', 'Dikkatlice'),
                                   ('Inevitable', 'Kaçınılmaz'),
                                   ('Perception', 'Algı'),
                                   ('Noteworthy', 'Dikkate değer'),
                                   ('Facilitate', 'Kolaylaştırmak'),
                                   ('Diminish', 'Azaltmak'),
                                   ('Simultaneously', 'Eşzamanlı olarak'),
                                   ('Subsequently', 'Sonradan'),
                                   ('Controversial', 'Tartışmalı'),
                                   ('Accumulate', 'Birikmek'),
                                   ('Conscientious', 'Vicdanlı'),
                                   ('Phenomenon', 'Olay'),
                                   ('Exaggerate', 'Abartmak'),
                                   ('Implicate', 'Bulaştırmak');
INSERT INTO Deck (name) VALUES
                                   ('English-Turkish');
INSERT INTO Deck_Cards (deck_id, cards_id) VALUES
                                   (1, 1),
                                   (1, 2),
                                   (1, 3),
                                   (1, 4),
                                   (1, 5),
                                   (1, 6),
                                   (1, 7),
                                   (1, 8),
                                   (1, 9),
                                   (1, 10),
                                   (1, 11),
                                   (1, 12),
                                   (1, 13),
                                   (1, 14),
                                   (1, 15),
                                   (1, 16),
                                   (1, 17),
                                   (1, 18),
                                   (1, 19),
                                   (1, 20);

INSERT INTO member (id,username,password) VALUES (133,'furkan','{noop}123456789');
INSERT INTO MEMBER_DECKS (decks_id,member_id) VALUES (1,133);


INSERT INTO Card (front, back) VALUES
                                   ('Bonjour', 'Hello'),
                                   ('Merci', 'Thank you'),
                                   ('Au revoir', 'Goodbye'),
                                   ('S''il vous plaît', 'Please'),
                                   ('Oui', 'Yes'),
                                   ('Non', 'No'),
                                   ('Excusez-moi', 'Excuse me'),
                                   ('Comment allez-vous?', 'How are you?'),
                                   ('Enchanté', 'Nice to meet you'),
                                   ('Pardon', 'Sorry'),
                                   ('Bonne nuit', 'Good night'),
                                   ('À bientôt', 'See you soon'),
                                   ('Je ne sais pas', 'I don''t know'),
                                   ('Bien sûr', 'Of course'),
                                   ('S''il vous plaît', 'Please'),
                                   ('De rien', 'You''re welcome'),
                                   ('À plus tard', 'See you later'),
                                   ('Bon appétit', 'Enjoy your meal'),
                                   ('Au revoir', 'Goodbye'),
                                   ('Bonne journée', 'Have a good day');

-- Create French deck
INSERT INTO Deck (name) VALUES ('French-English');

-- Get the new deck ID (assuming it's 2 since there's only one existing deck)
-- Associate cards with the French deck
INSERT INTO Deck_Cards (deck_id, cards_id)
SELECT 2, id FROM Card WHERE id > 20 ORDER BY id ASC LIMIT 20;

-- Associate the new deck with user 1
INSERT INTO MEMBER_DECKS (decks_id, member_id) VALUES (2, 133);