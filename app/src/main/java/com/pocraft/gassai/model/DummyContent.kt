package com.pocraft.gassai.model

import java.time.LocalDate

val dummySchedule = arrayOf("Day 1", "Day 2", "Saved")

val venue1 = Venue(0, "銀座")
val venue2 = Venue(1, "上通り")
val venue3 = Venue(2, "下通り")
val venue4 = Venue(3, "二の丸")
val dummyVenueList = listOf(venue1, venue2, venue3, venue4)

val t1 = Team(0, "甘木よさこい連", "福岡県", "朝倉市","あさくらよさこい祭り",3, "2001年結成。九州北部豪雨から2年半が経ち、まだまだ復興途中ですが、地元を元気にしたいという想いを胸に活動しています。観てくださる皆様の魂を揺らす演舞をしたいと思います！。")
val t2 = Team(1, "よしいウイング～心華～", "福岡県", "うきは市","うきはYOSAKOI祭り", 1, "チーム結成16周年に向け、初心を忘れず、今後も皆様に踊りを通して楽しさや感動をお伝え出来る演舞を目指し、又、より多くの方々に私達の故郷”うきは”を知って頂ける様幅広く活動しています。")
val t3 = Team(2, "うきはYOSAKOI祭りPR隊", "福岡県", "うきは市","うきはYOSAKOI祭り", 3, "「夏より熱い秋」をコンセプトに毎年9月に開催しています「うきはYOSAKOI祭り」のPR隊です。白壁と清流に棚田、自然豊かなフルーツの里！私達の故郷を唄った楽曲を演舞させて頂きます。")
val t4 = Team(3, "熊本応援隊～筑連～", "福岡県", "筑後地区","おおかWA！ダンスまつり", 1, "私達は筑前・筑後の踊り子達が九州熊本に「元気を！」そして「1日も早く日常の生活に戻られます様に」と願いを込めて集まった本日限りの合同チーム「熊本応援隊～筑連～」です。宜しくお願い致します。")
val t5 = Team(4, "本城西おりひめ隊", "福岡県", "北九州市","折尾まつり", 1, "こんにちは、北九州市八幡西区で活動している本城西おりひめ隊です。本日は熊本の復興とさらなる発展を願い参加させていただきました。皆様の力になれますよう、心を込めて演舞させていただきます。")
val t6 = Team(5, "黒崎よさこい連", "福岡県", "北九州市","黒崎よさこい祭り", 1, "私達は黒崎よさこい祭りのPR隊として活動しています。 少人数ではありますが、お祭を盛上げるよう頑張って踊ります。 ご声援、よろしくお願いいたします。")
val t7 = Team(6, "夢追いたい", "福岡県", "北九州市","黒崎よさこい祭り", 1, "今年9月で結成8年目を迎えます「夢追いたい」です。 北九州の生涯現役夢追い塾の卒塾生で結成され、全員が60代のシニアチームですが、現在は地域の祭りや町の小さなイベント、高齢者施設などに演舞参加し、皆さんに喜んでもらうと共に、メンバーも元気をもらい楽しく踊っています。")
val t8 = Team(7, "よさこい古賀連", "福岡県", "古賀市","食の祭り (古賀の郷)", 1, "地元では元気と笑顔で活動しています。古賀連も年齢に関係なく、楽しくをモットーによさこい仲間は今年も変りない人の為、世の為、自分の為、自分の健康はよさこいで守ろう!!よろしくネ。")
val t9 = Team(8, "福岡県田川市PRキャラバン隊", "福岡県", "田川市","TAGAWAコールマイン・フェスティバル～炭坑節まつり～", 2, "田川市は「月が出た出た」でお馴染みの炭坑節発祥の地です。毎年11月第1土日に開催される標記の祭りでは、炭坑節の変遷がわかる催しや1万人規模で踊る総踊りなど、本場の炭坑節を満喫できる絶好のイベントです！皆様のお越しをお待ちしています！")
val t10 = Team(9, "太宰府まほろば衆", "福岡県", "太宰府市","太宰府門前真舞祭", 2, "福岡県太宰府市から参りました太宰府まほろば衆です。キッズチームの「太宰府まほろば衆 こうめ」と一緒に、ここ熊本で踊れる喜びをかみしめながら、見てくださる方が元気になるような演舞をしたいと思います。どうぞよろしくお願い致します。")
val t11 = Team(10, "ちっご☆きずな隊", "福岡県", "筑後市","ちっご祭り『ちっごはねてん祭』", 1, "福岡県筑後市のYOSAKOIチーム、ちっごきずな隊です。YOSAKOIを通し、踊る楽しさ、魅せる喜び、そしてなにより一つのものをみんなで創り上げる感動体験味わっています（＾＾）")
val t12 = Team(11, "千代流", "福岡県", "福岡市","博多祇園山笠", 1, "博多祗園山笠千代流飾山「がんばろう熊本」博多の夏を元気にする山笠が、がっ祭と一緒に熊本を元気にします。熊本城に清正公、武蔵に、阿蘇の山、おんだ祭に蛍丸伝説。熊本県を山笠に総飾りします。※2017年7月の博多祇園山笠 千代流の飾り山です。")
val t13 = Team(12, "ＥＮＴＯＲＡＮＣＥ１０２", "福岡県", "福岡市","ふくこいアジア祭り", 4, "チームとして新たなチャレンジをしている今年、昨年の作品「ENGINE」をさらにパワーアップさせてステージに臨みます。メンバー全員がいつも以上に自分達の手で育てたチームと作品で今年も精一杯演舞します。")
val t14 = Team(13, "流", "福岡県", "福岡市","ふくこいアジア祭り", 3, "祝うたァ！どんたく・山笠・にわか・博多弁。福岡が誇る伝統文化、そして、心から愛する福岡の魅力を全力で熱く表現します。「アトラクション福岡」4分半という僅かなひと時、共に楽しみましょう。輝け！福岡！")
val t15 = Team(13, "あかし", "福岡県", "福岡市","ふくこいアジア祭り", 2, "福岡市で活動している「あかし」ともうします。今回はオリジナル楽曲である「烽」を演舞いたします。私たちが始まったきっかけであるこの曲をぜひご覧ください。")
val t16 = Team(13, "ＪＲ九州櫻燕隊", "福岡県", "福岡市","ふくこいアジア祭り", 1, "私達ＪＲ九州櫻燕隊は、駅・車掌・運転士・客室乗務員など、全てＪＲ九州の社員で構成されております。鉄道員らしいキビキビとした動きで、皆さまに感動と元気を届けられるよう、精一杯演舞いたします。")
val t17 = Team(13, "Smile Angel", "福岡県", "福岡市","ふくこいアジア祭り", 2, "福岡県福岡市で活動しているSmileAngelです。久しぶりの参加ですが、皆様に笑顔と元気を届けられる様に演舞いたします。")
val t18 = Team(13, "博多よさこい連　弁天", "福岡県", "福岡市","ふくこいアジア祭り", 3, "福岡市で活動している博多よさこい連です。今年は「唯一、宮本武蔵に勝ったとされる男」夢想権之助（むそうごんのすけ）をテーマに踊ります。")
val t19 = Team(13, "ペプシJコーラ　怪物舞踏団", "日本全国", "","ふくこいアジア祭り", 1, "石川さゆり、SUGIZO、KenKen、DJ RENA、にゃんごすたーで結成されたペプシ J コーラ「怪物舞踏団」の楽曲「百鬼夜行」とともに、波マークがシンボルの私達スペシャルチームが心一つに演舞いたします。")
val t20 = Team(13, "美勝女隊", "福岡県", "那珂川町","ふくこいアジア祭り", 2, "私たちは小学1年生から高校２年生までの平均年齢１１歳のチームです。今年は鬼と鶴と孔雀をテーマに作り上げました。作品の後半では、日本が世界に誇る伊藤若沖の世界に挑戦します！どうぞご声援のほどよろしくお願いします！")
val t21 = Team(13, "福岡大学附属若葉高等学校ダンス部", "福岡県", "福岡市","ふくこいアジア祭り", 3, "自らの可能性に挑戦！！今年で創部 47 年目を迎えます。新体制になって初めてのステージです。会場の皆様に笑顔とパワーをお届けできるよう精一杯踊ります。心はひとつ！パワー全開！！")
val t22 = Team(13, "ふくこい踊り隊", "福岡県", "福岡市","ふくこいアジア祭り", 4, "博多の町を彩る四季折々のお祭りの賑わいを、リズミカルな「楽曲」、艶やかな「振付」、オリジナルな「衣装」による華麗な演舞に乗せて、ご覧頂く皆様へお届けします！")
val t23 = Team(13, "ふくこい連", "福岡県", "福岡市","ふくこいアジア祭り", 4, "福岡県福岡市で活動しています「ふくこい連」です。皆様に福が舞い降りて来ますように「福よ、来い」の願いを込め、またふくこいアジア祭りを通し福岡からアジアに広がるお祭りを目指し各地で踊っています。")
val t24 = Team(13, "YOSAKOI亜舞王城島連", "福岡県", "久留米市","城島ふるさと夢まつり／城島酒蔵まつり", 4, "本日は九州がっ祭2020ご開催誠におめでとうございます。チームを結成して1曲目の祝風からスタートし2曲目風龍、3曲目龍天、4曲目天宝、5曲目が本日初披露となります。宝神が完成しました。今年も熊本を元気に笑顔をいっぱいで演舞させて頂きます。")
val t25 = Team(13, "福女パンチャカンニャ", "福岡県", "福岡市","Friends without Border", 3, "福岡女学院大学国際キャリア学科の留学生チームです。「誰が反対しても私たちは会おうね」という愛の曲に、ネパール・モダン・トラディショナル・ダンスの振り付けをします。私たちも国境に関係なく皆さんと心をつなげたいです。")
val t26 = Team(13, "威吹", "福岡県", "糟屋郡粕屋町","YOSAKOIかすや祭り", 4, "私たちの勢いのある演舞と、元気いっぱいの声で会場を盛り上げます！テーマは狼(オオカミ)です。衣装の背中にある月と、ズボンの狼にもご注目ください！ご声援よろしくお願いいたします！")
val t27 = Team(13, "桜舞連", "福岡県", "糟屋郡粕屋町","YOSAKOIかすや祭り", 4, "今年踊ります曲は「桜一路」。仲間と共に信じた道その一本の道を歩んでいこう。という思いを込めました。桜咲き誇る中、踊らさせて頂く。まさに桜舞連が一番輝ける季節だと思っております。本物の桜に負けぬよう演舞致します。どうぞ桜舞連宜しくお願い致します。")
val t28 = Team(13, "粕屋東中中学連 輝龍天翔", "福岡県", "糟屋郡粕屋町","YOSAKOIかすや祭り", 1, "福岡県粕屋町より来ました。粕屋東中中学連輝龍天翔です。よさこいが好きな生徒が集まって活動しています。学生らしく元気いっぱい笑顔いっぱいで楽しく演舞したいと思います。")
val t29 = Team(13, "志免清龍隊", "福岡県", "志免町","YOSAKOIかすや祭り", 4, "今年も熊本で踊れることに感謝。踊り子一同、熊本へ精一杯のエール！そして目いっぱい楽しみます。どうぞよろしくお願いします。")
val t30 = Team(13, "筑前かすや一番隊", "福岡県", "糟屋郡粕屋町","YOSAKOIかすや祭り", 4, "私たち筑前かすや一番隊は、福岡県粕屋町のオフィシャルチームです。「人おこし、まちおこし、魂おこし」の想いを込めて活動しています。よろしくお願いします。")
val t31 = Team(13, "大和撫子ひなあられ隊", "福岡県", "糟屋郡粕屋町","YOSAKOIかすや祭り", 1, "私達は、50代から70代の女性だけのチームで、今年で結成17年目を迎えました。これからもたくさんの人達と交流を深めながら、楽しくいい年を重ねて行きたいです。今年も元気に舞い踊ります。")
val t32 = Team(13, "踊ッ天童！かすや親善隊", "福岡県", "粕屋町","YOSAKOIかすや祭り", 1, "YOSAKOIかすや祭りのオフィシャル総踊り連です。今年でかすや祭りは20周年を迎えますが、そのPRキャラバン隊として九州がっ祭がその記念すべき最初の祭りです。祭りを盛り上げるべく元気に踊ります！ご声援よろしくお願いいたします。")
val t33 = Team(13, "若翔連", "福岡県", "粕屋町","YOSAKOIかすや祭り", 1, "福岡県粕屋町からまいりました。親子で踊り子が多いチームです。町外で演舞することはあまりないのでとても楽しみにしています。")
val t34 = Team(13, "草野キッズビクス", "福岡県", "久留米市","ふるさとみづま祭", 2, "福岡は久留米、久留米は草野町より参りました、草野キッズビクスと申します。小学１年生から高校生まで、姉妹のようなチームです。大空を舞う鳥のようにノビノビ演舞させていただきますっ♡")
val t35 = Team(13, "久留米大学よさこい愛好会颯華", "福岡県", "久留米市","ふるさとみづま祭", 1, "久留米大学よさこい愛好会颯華です。颯華は九州がっ祭初参加です。この九州がっ祭をもちまして昨年度楽曲、葵舞翔（アマト）のお祭りでの踊り納めとなります。颯華一同全力で演舞いたしますのでご声援のほどよろしくお願いします。")
val t36 = Team(13, "北九州市立大学よさこいサークル灯炎", "福岡県", "北九州市","わっしょいYOSAKOI北九州", 4, "こんにちは！北九州市立大学よさこいサークル灯炎です。私達灯炎は、今回の九州がっ祭で新曲のお披露目とさせて頂きます。衣装や曲等々、すべてにこだわった曲になっていますので、皆さん是非お越しくだい。よろしくお願いします。")
val t37 = Team(13, "北九州よさこいPR隊", "福岡県", "北九州市","わっしょいYOSAKOI北九州", 2, "北九州の合同チームです！1人1人の「力」が集まって大きな「力」となり、街の「力」となりますよう、パワー全開で踊ります！")
val t38 = Team(13, "北九州わっしょい百万隊", "福岡県", "北九州市","わっしょいYOSAKOI北九州", 1, "結成13年、5才から60代までのメンバーで大きな家族のように楽しく踊っています。今回は新曲！！心を一つにして皆様に笑顔と元気のプレゼントができるよう心を込めて踊ります。")
val t39 = Team(13, "月華美神", "福岡県", "北九州市","わっしょいYOSAKOI北九州", 1, "北九州市で活動している月華美神と申します。今年初めての祭りがこの熊本で迎えられることとても嬉しく思います。初心に返って結成当初の曲わっしょい2003を少ない人数ですが精一杯踊ります。最後までご声援よろしくお願いします。")
val t40 = Team(13, "むなかたおどり隊", "福岡県", "宗像市","わっしょいYOSAKOI北九州", 4, "神宿る島沖ノ島、宗像大社がある宗像からやってまいりました。3歳から60代までの3世代型のファミリーチームです。熊本の応援団として今年も参加しました。")
val t41 = Team(13, "向日葵", "福岡県", "北九州市","わっしょいYOSAKOI北九州", 2, "北九州YOSAKOI連絡協議会の合同チーム「向日葵」です。結成1周年！大人も子供もみんなで頑張ります！北九州は面白くて楽しい街♪ぜひ、遊びに来てくださいね！")
val t42 = Team(13, "舞道", "福岡県", "北九州市","わっしょいYOSAKOI北九州", 1, "北九州はレトロの街、門司港で活動しています、舞道と申します。九州がっ祭2020開催誠におめでとうございます。今日は楽しく元気いっぱい演舞しますのでどうぞよろしくお願いします。")
val t43 = Team(13, "元気印からつっ子NNP", "佐賀県", "唐津市","踊れ！いとしま", 1, "佐賀県唐津市から参加しました、NNPのジュニアチームです。熊本の大きな舞台で元気いっぱいの踊りを披露したいと思います。よろしくお願いします。")
val t44 = Team(13, "博多よさこい連", "福岡県", "福岡市","博多どんたく", 1, "福岡市より参りました博多よさこい連です。今年は福岡三大祭りの「博多どんたく」をテーマにしております。どんたくには戦前に途絶え、戦後に「博多復興祭」として復活した歴史があります。熊本の皆様への復興の想いを込め博多の元気を皆様にお届け致します！！")
val t45 = Team(13, "宵あさ", "福岡県", "福岡市","大蛇山祭り", 1, "「最高に美味い酒を飲むために」をコンセプトに九州の若者で活動しているよさこいチームです。まだ結成して間もないですが、宵から朝まで祭りに明け暮れお祭りを盛り上げていきます。")

//val t35 = Team(13, "", "福岡県", "","", , "")
val dummyTeamList = listOf(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,t40,t41,t42,t43,t44,t45)

val post1 = Post(0, "「WEB版九州がっ祭」開催のご案内1", "www.www", LocalDate.now())
val post2 = Post(1, "「WEB版九州がっ祭」開催のご案内2", "www.www", LocalDate.now())
val post3 = Post(2, "「WEB版九州がっ祭」開催のご案内3", "www.www", LocalDate.now())
val post4 = Post(3, "「WEB版九州がっ祭」開催のご案内4", "www.www", LocalDate.now())
val post5 = Post(4, "「WEB版九州がっ祭」開催のご案内5", "www.www", LocalDate.now())
val post6 = Post(5, "「WEB版九州がっ祭」開催のご案内6", "www.www", LocalDate.now())
val dummyPostList = listOf(post1, post2, post3, post4, post5, post6)

val session1 = Session(0, t1, venue1, 1, LocalDate.now())
val session2 = Session(1, t2, venue1, 1, LocalDate.now())
val session3 = Session(2, t1, venue1, 1, LocalDate.now())
val session4 = Session(3, t1, venue1, 1, LocalDate.now())
val session5 = Session(4, t2, venue1, 1, LocalDate.now())
val session6 = Session(5, t1, venue1, 1, LocalDate.now())
val session7 = Session(6, t1, venue1, 1, LocalDate.now())
val session8 = Session(7, t2, venue1, 1, LocalDate.now())
val session9 = Session(8, t1, venue1, 1, LocalDate.now())
val session10 = Session(9, t1, venue1, 1, LocalDate.now())
val session11 = Session(10, t1, venue1, 1, LocalDate.now())
val session12 = Session(11, t2, venue1, 1, LocalDate.now())
val session13 = Session(12, t1, venue1, 1, LocalDate.now())
val dummySessionDay1 = listOf(session1, session2, session3, session4, session5, session6, session7, session8, session9,
    session10, session11, session12, session13)