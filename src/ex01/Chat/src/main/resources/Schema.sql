CREATE SCHEMA bootcamp;

CREATE TABLE IF NOT EXISTS bootcamp."User"
(
    ID       SERIAL PRIMARY KEY,
    Login    varchar(255) NOT NULL,
    Password varchar(255) NOT NULL,
    UNIQUE (Login),
    UNIQUE (Login, Password)
);

CREATE TABLE IF NOT EXISTS bootcamp.Chatroom
(
    ID    SERIAL PRIMARY KEY,
    name  varchar(255) NOT NULL,
    owner int          NOT NULL,
    UNIQUE (name),
    CONSTRAINT fk_user FOREIGN KEY (owner) REFERENCES bootcamp."User" (ID)
);

CREATE TABLE IF NOT EXISTS bootcamp.Message
(
    ID     SERIAL PRIMARY KEY,
    author int          NOT NULL,
    room   int          NOT NULL,
    text   VARCHAR(255) NOT NULL,
    time   TIMESTAMP(0) NOT NULL,
    CONSTRAINT fk_author FOREIGN KEY (author) REFERENCES bootcamp."User" (ID),
    CONSTRAINT fk_room FOREIGN KEY (room) REFERENCES bootcamp.Chatroom (ID)
);

CREATE TABLE IF NOT EXISTS bootcamp.UserChatroom
(
    UserID     INT,
    ChatRoomID INT,
    CONSTRAINT fk_chatroom FOREIGN KEY (ChatRoomID) REFERENCES bootcamp.Chatroom (ID),
    CONSTRAINT fk_message FOREIGN KEY (UserID) REFERENCES bootcamp."User" (ID),
    PRIMARY KEY (ChatRoomID, UserID)
);
