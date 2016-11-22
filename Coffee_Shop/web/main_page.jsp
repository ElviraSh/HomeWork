<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 11.11.2016
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="css/Style_main.css">
    <link href="https://fonts.googleapis.com/css?family=Indie+Flower|Roboto" rel="stylesheet">
    <title>CoffeeShop</title>

    <script type="text/javascript" src="/js/image_slide.js"></script>
</head>
<body>
<div id="header">

    <div class="text"><a href="coffee.jsp?page=1" >Ознакомиться с нашим меню можно здесь</a></div>
    <div class="text">|</div>
    <div class="text"><a href="login">Вход</a> </div>

    <div class="text">|</div>

    <div class="text"><a href="/registration1.jsp">Регистрация</a> </div>
</div>


<div id="content">

    <h1> <img src="img/hb-logo.png" width="100px" height="100px">Coffee shop</h1>


<div class="image" style="padding: 5px">
    <img src='img/slide_1.jpg' id="image_1" width="99%" height="70%" style="position: absolute;" />
    <img src='img/slide_2.jpg' id="image_2" width="99%" height="70%" style="opacity: 0; filter: alpha(opacity=0); position: absolute;" />
    <img src='img/slide_3.jpg' id="image_3" width="99%" height="70%" style="opacity: 0; filter: alpha(opacity=0); position: absolute;" />
    <img src='img/slide_4.jpg' id="image_4" width="99%" height="70%" style="opacity: 0; filter: alpha(opacity=0); position: absolute;"  />
    <img src='img/slide5.jpg' id="image_5" width="99%" height="70%" style="opacity: 0; filter: alpha(opacity=0); position: absolute;"  />
    <img src='img/slide6.jpg' id="image_6" width="99%" height="70%"  style="opacity: 0; filter: alpha(opacity=0); position: absolute;"  />
    <img src='img/slide7.jpg' id="image_7" width="99%" height="70%" style="opacity: 0; filter: alpha(opacity=0); position: absolute;"  />
    <img src='img/slide8.jpg' id="image_8" width="99%" height="70%"  style="opacity: 0; filter: alpha(opacity=0); position: absolute;"  />
</div>


    <div class="text2">

        Для многих людей кофе — это своеобразная религия, любовь, священный ритуал. Если вы тоже любите этот прекрасный напиток, то вам точно будет интересно узнать о нём весьма необычные факты.

        <br>
        Ваше тело по утрам естественно производит гормон кортизол, который поможет вам чувствовать себя бодрым и свежим. Это обусловлено особенностями человеческого организма, так называемыми циркадными суточными ритмами. Так что если у вас есть привычка пить кофе по утрам, чтобы проснуться, то это совершенно не имеет смысла. Гораздо лучше подождать, когда уровень кортизола снизится, а это наступит после 9–10 часов утра, и уже тогда выпить чашку кофе.<br>
        1.<br>
        Считается, что о свойствах кофе впервые узнал эфиопский пастух Калди, который заметил, что его козы становятся энергичными после того, как употребляют ягоды с незнакомого дерева. («Краткая история кофе»)<br>
        2.<br>
        Изначально люди употребляли кофейные ягоды в пищу, а уже потом из него стали готовить напиток.<br>
        3.<br>
        Весь кофе в мире растет в довольно узком коридоре между тропиком рака и тропиком козерога.<br>
        4.<br>
        На протяжении своей истории кофейни неоднократно запрещали власти различных стран. Наиболее известен запрет в Мекке в 1511 году и в Англии в 1675 году. Как правило, власти считали кофейни источником революционных мыслей и местом сбора заговорщиков.<br>
        5.<br>
        И это было правдой. Впоследствии Бостонское чаепитие 1773 года и Великая французская революция 1789 года также частично планировались в кофейнях.<br>
        6.<br>
        Кофе содержит более 1200 химических соединений, более половины из которых отвечают за вкусовые качества получаемого напитка.<br>
        7.<br>
        На долю арабики приходится 70%, а на робусту – 30% мирового потребления кофе.<br>
        8.<br>
        Кофе – один из самых торгуемых товаров на мировых биржах. По объему его опережает только нефть. Заметьте, и кофе, и нефть – жидкости темного цвета. Совпадение?	<br>
        9.<br>
        Каждый год в мире выпивается более 500 млрд. чашек кофе. Более половины – за завтраком (или вместо?).	<br>
        10.<br>
        С точки зрения потребления кофе на душу населения в год лидируют страны Северной Европы – Финляндия (12 кг), Норвегия (9,9 кг), Исландия (9 кг). Россия на 56 месте в этом списке (1,7 кг).<br>
        11.<br>
        Добавлять молоко в кофе стали в 17 веке. Такой рецепт выписывал своим пациентам один французский врач.	<br>
        12.<br>
        Растворимый кофе впервые поступил в продажу в США в 1910 году. Его изобретателя звали Джордж Констант Луи Вашингтон.	<br>
        13.<br>
        Слово американо появилось в годы Второй мировой войны, когда американские солдаты в Европе стали добавлять в эспрессо кипяток, чтобы разбавить крепкий напиток.<br>
        14.<br>
        Ирландский кофе был изобретен в аэропорту ирландского города Фойнс, когда шеф-повар ресторана решил добавить виски в кофе, чтобы согреть прибывших в зимнюю стужу американских пассажиров.<br>
        15.<br>
        Первая веб-камера была разработана в Кембриджском университете, чтобы определять на расстоянии, заполнена или пуста университетская кофеварка.<br>
        16.<br>
        На спа-курорте Юнессун в Японии можно искупаться в настоящем кофе, который, как считают японцы, помогает сохранить тонус кожи. Там же можно поплавать в настоящем зеленом чае.	<br>
        17.<br>
        Смертельная доза кофеина равно примерно 100 чашкам кофе.	<br>
        18.<br>
        При этом французский философ Вольтер выпивал до 50 чашек кофе в день!	<br>
        19.<br>
        Иоганн Себастьян Бах написал Кофейную кантату в 1732-1734 гг. по заказу владельца кофейного дома Циммермана в Лейпциге. В этом юмористическом произведении кофе воспевается как необходимый человеку напиток.	<br>
        20.<br>
        В отличие от своих коллег в Новом свете средний возраст бариста в Италии составляет 45 лет. Сама профессия также считается очень престижной в этой стране.<br>
        21.<br>Кофе светлой обжарки содержит больше кофеина, чем темной.	<br>
        22.<br>
        Во многих странах есть кофейные праздники. Национальные дни кофе отмечают в Коста-Рике 12 сентября, в Ирландии – 19 сентября, в Японии – 1 октября.	<br>
        23.<br>
        Кофеин числится среди запрещенных веществ в списке, утвержденном Международным олимпийским комитетом, вместе со стероидами и кокаином. Употребление более 5 чашек кофе (12 микрограмм на 1 миллилитр мочи) считается МОК попыткой спортсмена получить преимущество в спортивной борьбе.<br>
<br><br>
    </div>


</div>

<div id="footer">

    <div class="text_footer" >Контакты   </div>

    <div class="text_footer" >8(900)900-90-00 <br> Наш контактный телефон"</div>



</div>

</body>
</html>
