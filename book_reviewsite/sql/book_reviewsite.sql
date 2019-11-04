set names utf8;

#メインデータベース
drop database if exists brsite;
create database if not exists brsite;
use brsite;

#会員情報テーブル
drop table if exists user_info;
create table user_info(
id int not null primary key auto_increment comment "管理No",
user_id varchar(16) unique comment "ユーザーID",
password varchar(16) comment "パスワード",
nickname varchar(16) comment "ニックネーム",
status tinyint default '0' comment "管理者権限",
regist_date datetime comment "登録日時",
update_date datetime comment "更新日時"
);

#書籍情報テーブル
drop table if exists book_info;
create table book_info(
book_id int not null primary key auto_increment comment "書籍管理No",
regiuser_id int not null comment "登録ユーザーNo",
title varchar(32) not null comment "タイトル",
author varchar(16) comment "著者",
co_author varchar(32) comment "共著者など",
publisher varchar(32) comment "出版元",
book_type varchar(16) not null comment "種別",
book_genre varchar(16) comment "ジャンル",
image_file_path varchar(100) not null default '未設定' comment "画像ファイルパス",
image_file_name varchar(50) not null default '未設定' comment "画像ファイル名",
regist_date datetime comment "登録日時",
update_date datetime comment "更新日時"
);

#レビュー情報テーブル
drop table if exists review_info;
create table review_info(
review_id int not null primary key auto_increment comment "レビュー管理No",
regiuser_id int not null comment "登録ユーザーNo",
book_id int not null comment "登録書籍No",
highlight varchar(32) comment "レビュー見出し",
text varchar(1000) not null comment "本文",
recommendation tinyint default '0' not null comment "オススメ度",
spoiler_flg boolean default '0' comment "ネタバレフラグ",
regist_date datetime comment "登録日時",
update_date datetime comment "更新日時"
);

#問い合わせ情報テーブル
drop table if exists inquiry_info;
create table inquiry_info(
inquiry_id int not null primary key auto_increment comment "問い合わせ管理No",
regiuser_id int not null comment "登録ユーザーNo",
itype varchar(32) comment "問い合わせ種別",
ititle varchar(32) comment "件名",
itext varchar(1000) not null comment "問い合わせ内容",
regist_date datetime comment "登録日時",
reply_date datetime comment "最終返信日時",
finish_flg boolean default '0' comment "解決済みフラグ"
);

#書籍種別マスターテーブル
drop table if exists b_type;
create table b_type(
type_id int not null primary key unique comment "種別管理No",
type_name varchar(16) not null unique comment "種別名",
regist_date datetime comment "登録日時",
update_date datetime comment "更新日時"
);

#ジャンルマスターテーブル
drop table if exists b_genre;
create table b_genre(
genre_id int not null primary key unique comment "ジャンル管理No",
genre_name varchar(16) not null unique comment "ジャンル名",
regist_date datetime comment "登録日時",
update_date datetime comment "更新日時"
);

#種別画像テーブル
drop table if exists image_info;
create table image_info(
book_type varchar(16) not null comment "対応書籍種別No",
image_file_path varchar(100) not null comment "画像ファイルパス",
image_file_name varchar(50) not null comment "画像ファイル名"
);

#テスト用の仮登録情報を設定
INSERT INTO user_info(user_id,password,nickname,status,regist_date,update_date) VALUES("admin","admin","アドミニストレータ",1,now(),now());
INSERT INTO user_info(user_id,password,nickname,status,regist_date,update_date) VALUES("a","a","山田太郎",0,now(),now());
INSERT INTO user_info(user_id,password,nickname,status,regist_date,update_date) VALUES("b","b","鈴木一郎",0,now(),now());
INSERT INTO user_info(user_id,password,nickname,status,regist_date,update_date) VALUES("c","c","田中三郎",0,now(),now());


INSERT INTO book_info(regiuser_id,title,author,co_author,publisher,book_type,book_genre,regist_date,update_date) VALUES(2,"世界一面白い本","最高太郎","最高次郎","世界一書店","小説","感動",now(),now());
INSERT INTO book_info(regiuser_id,title,author,co_author,publisher,book_type,book_genre,regist_date,update_date) VALUES(1,"オンリーロンリーグローリー","バンプファン","クロネコK","BUMP OF SHOTEN","同人誌","青春",now(),now());
INSERT INTO book_info(regiuser_id,title,author,co_author,publisher,book_type,book_genre,regist_date,update_date) VALUES(3,"ナノフォトニクスのための非線形光学効果入門","朝永哲雄","石井義則","オーム社","学術書","その他",now(),now());
INSERT INTO book_info(regiuser_id,title,author,co_author,publisher,book_type,book_genre,regist_date,update_date) VALUES(2,"勇者エドウィンの大冒険","面白い漫画絶対角太郎","友人A","立川文庫","コミック","感動",now(),now());
INSERT INTO book_info(regiuser_id,title,author,co_author,publisher,book_type,book_genre,regist_date,update_date) VALUES(3,"THIS IS THE PEN","Haward Winston","Kolin taylor","OWK-wood store","小説","サスペンス",now(),now());
INSERT INTO book_info(regiuser_id,title,author,co_author,publisher,book_type,book_genre,regist_date,update_date) VALUES(2,"さっちゃんはおるすばん","藤田智子","","キッズブックス","絵本","その他",now(),now());



INSERT INTO review_info(regiuser_id,book_id,highlight,text,recommendation,regist_date,update_date) VALUES(2,1,"今世紀最高の感動をあなたに！","私がこの本に出会ったのは本当に偶然だった。いつもの仕事帰りに寄った本屋で、何となく装丁が気になって手に取ったその本が、まさかこんなに素晴らしい本だとは思いも寄らなかった。",5,now(),now());
INSERT INTO review_info(regiuser_id,book_id,highlight,text,recommendation,regist_date,update_date) VALUES(1,3,"非線形光学効果の参考書に迷ったらこれ！","めっちゃ分かりやすい！ボロボロになるまで読みました！",4,now(),now());
INSERT INTO review_info(regiuser_id,book_id,highlight,text,recommendation,regist_date,update_date) VALUES(3,2,"一体どこにこんなに隠れバンパーが潜んでいたのか？","BUMP OF CHICKENのファンに取っては嬉しい一冊…かと思いきや、やや分量にバラ付きがある上、作者のアクが強くて読みにくい。BUMPについてのデータを集めた巻末付録のページは良かった",2,now(),now());
INSERT INTO review_info(regiuser_id,book_id,highlight,text,recommendation,regist_date,update_date) VALUES(1,4,"流行っていたので買ってみたけど…","面白くなかったのですぐに売りました",1,now(),now());
INSERT INTO review_info(regiuser_id,book_id,highlight,text,recommendation,regist_date,update_date) VALUES(2,4,"こんな熱い漫画読んだことありません！！！","タイトル通りエドウィンの大冒険を描いた、今話題沸騰の傑作！！ありふれた設定ながら王道を突き進む主人公の姿に思わず読む手に汗握ります！お気に入りのシーンは第４部の四天王ダワルダーと戦うシーン…！、絶対絶命の瞬間に駆けつけたあのキャラに思わず涙が止まりません！！！ぜひ読んでみてください！！",5,now(),now());
INSERT INTO review_info(regiuser_id,book_id,highlight,text,recommendation,regist_date,update_date) VALUES(3,5,"タイトルからは想像もつかない恐ろしい展開に…！","前作に引き続き旅行先で事件巻き込まれるジョン。ホテルにチェックインしようとしたその時、フロントに置かれていた一本のペンからとんでもない事件に巻き込まれる…。ハワード・ウィンストンの傑作ともいうべき本作は来春に映画化も予定されているらしい。真相をどちらで知るかはあなた次第…",5,now(),now());
INSERT INTO review_info(regiuser_id,book_id,highlight,text,recommendation,spoiler_flg,regist_date,update_date) VALUES(4,5,"サスペンスの金字塔、ここにありき","面白かった。まさかジョンの恋人が犯人だなんて。トリックに使われたペンはファングッズとして販売して欲しい",3,1,now(),now());



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

#基本的なジャンル情報を登録
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

#書籍種別に対応した画像情報を登録
INSERT INTO image_info(book_type,image_file_path,image_file_name) VALUES
("コミック","./images","bi_comic.png")
,("小説","./images","bi_novel.png")
,("ライトノベル","./images","bi_light.png")
,("絵本","./images","bi_pic.png")
,("参考書","./images","bi_ref.png")
,("学術書","./images","bi_study.png")
,("同人誌","./images","bi_dojin.png")
,("その他","./images","bi_another.png");