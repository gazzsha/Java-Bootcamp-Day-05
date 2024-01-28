INSERT INTO bootcamp."User"(login, password)
VALUES ('antoinco', '123');
INSERT INTO bootcamp."User"(login, password)
VALUES ('gradyzan', '123');
INSERT INTO bootcamp."User"(login, password)
VALUES ('kristina', '111');
INSERT INTO bootcamp."User"(login, password)
VALUES ('artem', '222');
INSERT INTO bootcamp."User"(login, password)
VALUES ('dima', '333');



INSERT INTO bootcamp.chatroom(name, owner)
VALUES ('C++ Chat',
        (SELECT ID FROM bootcamp."User" WHERE login = 'antoinco'));
INSERT INTO bootcamp.chatroom(name, owner)
VALUES ('Java Chat',
        (SELECT ID FROM bootcamp."User" WHERE login = 'gradyzan'));
INSERT INTO bootcamp.chatroom(name, owner)
VALUES ('C Chat',
        (SELECT ID FROM bootcamp."User" WHERE login = 'kristina'));

INSERT INTO bootcamp.Message(author, room, text, time)
VALUES ((SELECT ID FROM bootcamp."User" WHERE login = 'antoinco'),
        (SELECT id FROM bootcamp.chatroom WHERE name = 'Java Chat'),
        'I love java',
        TO_TIMESTAMP('2024-01-24 15:23:30', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO bootcamp.Message(author, room, text, time)
VALUES ((SELECT ID FROM bootcamp."User" WHERE login = 'gradyzan'),
        (SELECT id FROM bootcamp.chatroom WHERE name = 'Java Chat'),
        'I hate Java',
        TO_TIMESTAMP('2024-01-24 16:01:20', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO bootcamp.Message(author, room, text, time)
VALUES ((SELECT ID FROM bootcamp."User" WHERE login = 'dima'),
        (SELECT id FROM bootcamp.chatroom WHERE name = 'C++ Chat'),
        'Всем привет',
        TO_TIMESTAMP('2024-01-25 10:01:44', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO bootcamp.Message(author, room, text, time)
VALUES ((SELECT ID FROM bootcamp."User" WHERE login = 'artem'),
        (SELECT id FROM bootcamp.chatroom WHERE name = 'C Chat'),
        'Всем привет',
        TO_TIMESTAMP('2024-01-25 12:20:21', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO bootcamp.Message(author, room, text, time)
VALUES ((SELECT ID FROM bootcamp."User" WHERE login = 'kristina'),
        (SELECT id FROM bootcamp.chatroom WHERE name = 'C Chat'),
        'привет',
        TO_TIMESTAMP('2024-01-25 12:25:21', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO bootcamp.Message(author, room, text, time)
VALUES ((SELECT ID FROM bootcamp."User" WHERE login = 'antoinco'),
        (SELECT id FROM bootcamp.chatroom WHERE name = 'C++ Chat'),
        'привет',
        TO_TIMESTAMP('2024-01-25 11:22:10', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO bootcamp.Message(author, room, text, time)
VALUES ((SELECT ID FROM bootcamp."User" WHERE login = 'artem'),
        (SELECT id FROM bootcamp.chatroom WHERE name = 'Java Chat'),
        'хейтер',
        TO_TIMESTAMP('2024-01-24 20:14:15', 'YYYY-MM-DD HH24:MI:SS'));


INSERT INTO bootcamp.UserChatroom(UserID, ChatRoomID)
VALUES ((SELECT ID FROM "User" WHERE login = 'antoinco'),
        (SELECT id FROM chatroom WHERE name = 'Java Chat'));
INSERT INTO bootcamp.UserChatroom(UserID, ChatRoomID)
VALUES ((SELECT ID FROM "User" WHERE login = 'antoinco'),
        (SELECT id FROM chatroom WHERE name = 'C++ Chat'));
INSERT INTO bootcamp.UserChatroom(UserID, ChatRoomID)
VALUES ((SELECT ID FROM "User" WHERE login = 'gradyzan'),
        (SELECT id FROM chatroom WHERE name = 'Java Chat'));
INSERT INTO bootcamp.UserChatroom(UserID, ChatRoomID)
VALUES ((SELECT ID FROM "User" WHERE login = 'kristina'),
        (SELECT id FROM chatroom WHERE name = 'C Chat'));
INSERT INTO bootcamp.UserChatroom(UserID, ChatRoomID)
VALUES ((SELECT ID FROM "User" WHERE login = 'dima'),
        (SELECT id FROM chatroom WHERE name = 'C++ Chat'));
INSERT INTO bootcamp.UserChatroom(UserID, ChatRoomID)
VALUES ((SELECT ID FROM "User" WHERE login = 'artem'),
        (SELECT id FROM chatroom WHERE name = 'Java Chat'));
INSERT INTO bootcamp.UserChatroom(UserID, ChatRoomID)
VALUES ((SELECT ID FROM "User" WHERE login = 'artem'),
        (SELECT id FROM chatroom WHERE name = 'C Chat'));

