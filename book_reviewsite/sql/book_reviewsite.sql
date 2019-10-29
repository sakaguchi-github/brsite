set names utf8;

#メインデータベースの新規作成
drop database if exists brsite;
create database if not exists brsite;
use brsite;

#会員情報テーブルの新規作成
drop table if exists user_info;
create table user_info(
id int not null primary key auto_increment,
user_id varchar(16) unique,
password varchar(16),
nickname varchar(16),
status tinyint default '0',
regist_date datetime,
update_date datetime
);

#書籍情報テーブルの新規作成
drop table if exists book_info;
create table book_info(
book_id int not null primary key auto_increment,
regiuser_id int not null references user_info(id),
title varchar(32) not null,
author varchar(16),
co_author varchar(32),
publisher varchar(32),
book_type int not null unique references b_type(type_id),
book_genre1 int references b_genre(genre_id),
book_genre2 int references b_genre(genre_id),
book_genre3 int references b_genre(genre_id),
regist_date datetime,
update_date datetime
);

#レビュー情報テーブルの新規作成
drop table if exists review_info;
create table review_info(
review_id int primary key not null auto_increment,
regiuser_id int references user_info(id),
book_id int not null references book_info(book_id),
highlight varchar(32),
text varchar(1000) not null,
recommendation tinyint default '0' not null,
spoiler_flg boolean default '0',
regist_date datetime,
update_date datetime
);

#問い合わせ情報テーブルの新規作成
drop table if exists inquiry_info;
create table inquiry_info(
inquiry_id int primary key not null auto_increment,
regiuser_id int references user_info(id),
itype varchar(32),
ititle varchar(32),
itext varchar(1000) not null,
regist_date datetime,
reply_date datetime,
finish_flg boolean default '0'
);

#書籍種別マスターテーブルの新規作成
drop table if exists b_type;
create table b_type(
type_id int primary key not null unique,
type_name varchar(16),
regist_date datetime,
update_date datetime
);

#ジャンルマスターテーブルの新規作成
drop table if exists b_genre;
create table b_genre(
genre_id int primary key not null unique,
genre_name varchar(16) not null unique,
regist_date datetime,
update_date datetime
);

#画像情報用テーブルの新規作成
drop table if exists image_table;
create table image_table(
image_file_path varchar(100) comment "画像ファイルパス",
image_file_name varchar(50) comment "画像ファイル名"
);

#テスト用の仮登録情報を設定
INSERT INTO user_info(user_id,password,nickname,status) VALUES("admin","admin","アドミニストレータ",1);
INSERT INTO user_info(user_id,password,nickname,status) VALUES("q","q","山田太郎",0);
INSERT INTO user_info(user_id,password,nickname,status) VALUES("aa","aa","鈴木一郎",0);

INSERT INTO book_info(regiuser_id,title,author,co_author,publisher,book_type,book_genre1) VALUES(2,"世界一面白い本","最高太郎","最高次郎","世界一書店",2,3);
INSERT INTO book_info(regiuser_id,title,author,co_author,publisher,book_type,book_genre1) VALUES(1,"オンリーロンリーグローリー","バンプファン","クロネコK","BUMP OF SHOTEN",7,9);
INSERT INTO book_info(regiuser_id,title,author,co_author,publisher,book_type,book_genre1) VALUES(3,"ナノフォトニクスのための非線形光学効果入門","朝永哲雄","石井義則","オーム社",6,11);

INSERT INTO review_info(regiuser_id,book_id,highlight,text,recommendation) VALUES(2,1,"今世紀最高の感動をあなたに！","私がこの本に出会ったのは本当に偶然だった。いつもの仕事帰りに寄った本屋で、何となく装丁が気になって手に取ったその本が、まさかこんなに素晴らしい本だとは思いも寄らなかった。",5);
INSERT INTO review_info(regiuser_id,book_id,highlight,text,recommendation) VALUES(1,3,"非線形光学効果の参考書に迷ったらこれ！","めっちゃ分かりやすい！ボロボロになるまで読みました！",4);
INSERT INTO review_info(regiuser_id,book_id,highlight,text,recommendation) VALUES(3,2,"一体どこにこんなに隠れバンパーが潜んでいたのか？","BUMP OF CHICKENのファンに取っては嬉しい一冊…かと思いきや、やや分量にバラ付きがある上、作者のアクが強くて読みにくい。BUMPについてのデータを集めた巻末付録のページは良かった",2);


INSERT INTO image_table VALUES("./images","booksample.png");
INSERT INTO image_table VALUES("./images","cafesample.jpg");

#基本的な書籍種別情報を登録
INSERT INTO b_type(type_id,type_name) VALUES
(1,"コミック")
,(2,"小説")
,(3,"ライトノベル")
,(4,"絵本")
,(5,"参考書")
,(6,"学術書")
,(7,"同人誌")
,(8,"その他");

#基本的なジャンルマスタ情報を登録
INSERT INTO b_genre(genre_id,genre_name) VALUES
(1,"青春")
,(2,"恋愛")
,(3,"感動")
,(4,"ホラー")
,(5,"サスペンス")
,(6,"推理")
,(7,"SF")
,(8,"伝記")
,(9,"ノンフィクション")
,(10,"歴史")
,(11,"その他");

