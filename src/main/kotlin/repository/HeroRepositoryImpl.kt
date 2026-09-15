package com.example.repository

import com.example.models.ApiResponse
import com.example.models.Hero
import kotlin.collections.emptyList

const val NEXT_PAGE_KEY = "Next Page"
const val PREVIOUS_PAGE_KEY = "Previous Page"


class HeroRepositoryImpl : HeroRepository{

    override val heroes: Map<Int, List<Hero>> by lazy { mapOf(
        1 to page1,
        2 to page2,
        3 to page3,
        4 to page4,
        5 to page5
    ) }

    override val page1 = listOf(
        Hero(
            id = 1,
            name = "Юдзи Итадори",
            image = "/images/itadori.jpg",
            about = "Итадори Юдзи (虎杖悠仁いたどりゆうじ Itadori Yūji?) — Главный протагонист Магической Битвы.",
            rating = 4.5,
            power = 90,
            month = "Март",
            day = "20",
            family = listOf(
                "Аой Тодо",
                "Сатору Годжо",
                "Чосо",
                "Сукуна Рёмен",
                "Каори Итадори",
            ),
            abilities = listOf(
                "Чёрная гроза (Divergent Fist)",
                "Расчленение (Dismantle)",
                "Огненная стрела (Fire Arrow)",
            ),
            natureTypes = listOf(
                "Проклятая энергия Сукуны"
            )
        ),
        Hero(
            id = 2,
            name = "Сатору Годжо",
            image = "/images/gojo.jpg",
            about = "Годжо Сатору (五ご条じょう悟さとる Gojō Satoru?) — сильнейший экзорцист современности, учитель Токийского колледжа магии.",
            rating = 4.9,
            power = 100,
            month = "Декабрь",
            day = "7",
            family = listOf(
                "Юдзи Итадори",
                "Мегуми Фушигуро",
                "Нобара Кугисаки",
                "Сугуру Гето",
            ),
            abilities = listOf(
                "Бесконечность (Infinity)",
                "Шесть глаз (Six Eyes)",
                "Пурпурный (Purple)",
            ),
            natureTypes = listOf(
                "Техника Бесконечности"
            )
        ),
        Hero(
            id = 3,
            name = "Тоджи Фушигуро",
            image = "/images/toji.jpg",
            about = "Фушигуро Тоджи (伏ふし黒ぐろ甚とうじ Fushiguro Tōji?) — наёмник, известный как 'Убийца магов', отец Мегуми Фушигуро.",
            rating = 5.0,
            power = 85,
            month = "Ноябрь",
            day = "3",
            family = listOf(
                "Мегуми Фушигуро",
                "Тсумики Фушигуро",
            ),
            abilities = listOf(
                "Небесное ограничение",
                "Мастерство холодного оружия",
                "Сверхчеловеческая скорость",
            ),
            natureTypes = listOf(
                "Нулевая проклятая энергия"
            )
        )
    )
    override val page2 = listOf(
        Hero(
            id = 4,
            name = "Мегуми Фушигуро",
            image = "/images/fushiguro_megumi.jpg",
            about = "Фушигуро Мегуми (伏ふし黒ぐろ恵めぐみ Fushiguro Megumi?) — ученик Токийского колледжа магии, обладатель техники Десяти теневых кукол.",
            rating = 4.7,
            power = 85,
            month = "Декабрь",
            day = "22",
            family = listOf(
                "Тоджи Фушигуро",
                "Тсумики Фушигуро",
            ),
            abilities = listOf(
                "Техника десяти теневых кукол",
                "Полное воплощение: Махаорага",
                "Теневой склад",
            ),
            natureTypes = listOf(
                "Техника десяти теней"
            )
        ),
        Hero(
            id = 5,
            name = "Сукуна Рёмен",
            image = "/images/sukuna.jpg",
            about = "Рёмен Сукуна (両りょう面めん宿すく儺な Ryōmen Sukuna?) — Король Проклятий, легендарное существо, обитающее в теле Юдзи Итадори.",
            rating = 5.0,
            power = 100,
            month = "Неизвестно",
            day = "Неизвестно",
            family = listOf(
                "Юдзи Итадори (сосуд)",
                "Урауме",
            ),
            abilities = listOf(
                "Расчленение (Dismantle)",
                "Огненная стрела (Fire Arrow)",
                "Малефисентное святилище",
            ),
            natureTypes = listOf(
                "Множественные проклятые техники"
            )
        ),
        Hero(
            id = 6,
            name = "Нобара Кугисаки",
            image = "/images/kugisaki.jpg",
            about = "Кугисаки Нобара (釘くぎ崎さき野の薔ば薇ら Kugisaki Nobara?) — ученица Токийского колледжа магии, использующая технику Куклы-соломы.",
            rating = 4.5,
            power = 80,
            month = "Август",
            day = "7",
            family = listOf(
                "Саори Кугисаки",
            ),
            abilities = listOf(
                "Техника куклы-соломы",
                "Резонанс (Resonance)",
                "Взрыв волос",
            ),
            natureTypes = listOf(
                "Техника куклы-соломы"
            )
        )
    )
    override val page3 = listOf(
        Hero(
            id = 7,
            name = "Аой Тодо",
            image = "/images/todo.jpg",
            about = "Тодо Аой (東とう藤どう葵あおい Tōdō Aoi?) — ученик Киотоского колледжа магии, обладает техникой Каминокого.",
            rating = 4.8,
            power = 88,
            month = "Июнь",
            day = "23",
            family = listOf(
                "Юдзи Итадори (братан)",
                "Такада-чан (идеал)",
            ),
            abilities = listOf(
                "Техника Каминокого",
                "Удар Божьего наказания",
                "Перемещение мест",
            ),
            natureTypes = listOf(
                "Техника Каминокого"
            )
        ),
        Hero(
            id = 8,
            name = "Кента Нанями",
            image = "/images/nanami.jpg",
            about = "Нанями Кента (七なな海み建けんた Nanami Kento?) — экзорцист первого класса, бывший наставник Юдзи Итадори.",
            rating = 4.6,
            power = 84,
            month = "Июль",
            day = "3",
            family = listOf(
                "Юдзи Итадори (подопечный)",
                "Сатору Годжо (коллега)",
            ),
            abilities = listOf(
                "Техника соотношения 7:3",
                "Проклятый инструмент: тупой меч",
                "Поле черного флага",
            ),
            natureTypes = listOf(
                "Техника соотношения"
            )
        ),
        Hero(
            id = 9,
            name = "Сугуру Гето",
            image = "/images/geto.jpg",
            about = "Гето Сугуру (夏げとう傑すぐる Getō Suguru?) — бывший лучший друг Сатору Годжо, ныне один из главных антагонистов.",
            rating = 4.9,
            power = 92,
            month = "Февраль",
            day = "3",
            family = listOf(
                "Сатору Годжо (бывший друг)",
                "Мимако и Маико (приёмные дочери)",
            ),
            abilities = listOf(
                "Техника Проклятого манипулирования духами",
                "Тысячелетний демон",
                "Поле: Вместилище духов",
            ),
            natureTypes = listOf(
                "Техника манипулирования духами"
            )
        )
    )
    override val page4 = listOf(
        Hero(
            id = 10,
            name = "Рю Исигами",
            image = "/images/ryu.jpg",
            about = "Исигами Рю (石がみ龍りゅう Ishigami Ryū?) — могущественный проклятый дух эпохи Хэйан, обладающий техникой Глаза бури.",
            rating = 4.4,
            power = 82,
            month = "Неизвестно",
            day = "Неизвестно",
            family = listOf(
                "Уро Такако (современник)",
                "Сукуна (современник)",
            ),
            abilities = listOf(
                "Техника Глаза бури",
                "Концентрированные выстрелы энергии",
                "Усиленные физические атаки",
            ),
            natureTypes = listOf(
                "Техника Глаза бури"
            )
        ),
        Hero(
            id = 11,
            name = "Уро Такако",
            image = "/images/uro.jpg",
            about = "Уро Такако (雨う露ろたか子こ Uro Takako?) — могучая экзорцистка эпохи Хэйан, обладающая техникой Небесной манипуляции.",
            rating = 4.3,
            power = 81,
            month = "Неизвестно",
            day = "Неизвестно",
            family = listOf(
                "Рю Исигами (современник)",
                "Член клана Уро (бывший)",
            ),
            abilities = listOf(
                "Техника Небесной манипуляции",
                "Создание пространственных разломов",
                "Полёт",
            ),
            natureTypes = listOf(
                "Техника Небесной манипуляции"
            )
        ),
        Hero(
            id = 12,
            name = "Махито",
            image = "/images/mahito.jpg",
            about = "Махито (真ま人ひと Mahito?) — проклятый дух, рождённый из ненависти людей, обладающий техникой Искажения души.",
            rating = 4.7,
            power = 86,
            month = "Неизвестно",
            day = "Неизвестно",
            family = listOf(
                "Джого (проклятый дух-союзник)",
                "Ханеми (проклятый дух-союзник)",
            ),
            abilities = listOf(
                "Техника Искажения души",
                "Самоизменение формы",
                "Домен: Самоигральная утроба",
            ),
            natureTypes = listOf(
                "Техника Искажения души"
            )
        )
    )
    override val page5 = listOf(
        Hero(
            id = 13,
            name = "Юта Оккоцу",
            image = "/images/yuta.jpg",
            about = "Оккоцу Юта (乙おっ骨こつ憂ゆう太た Okkotsu Yūta?) — особый класс экзорциста, ученик Сатору Годжо, обладающий огромным запасом проклятой энергии.",
            rating = 4.9,
            power = 94,
            month = "Март",
            day = "7",
            family = listOf(
                "Рика Оримото (проклятый дух)",
                "Маки Дзенъин (подруга)",
                "Сатору Годжо (наставник)",
            ),
            abilities = listOf(
                "Копирование техник",
                "Огромный запас проклятой энергии",
                "Исцеление реверс-проклятой техникой",
            ),
            natureTypes = listOf(
                "Копирование техник"
            )
        ),
        Hero(
            id = 14,
            name = "Маки Дзенъин",
            image = "/images/maki.jpg",
            about = "Дзенъин Маки (禪ぜん院いん眞まき Zen'in Maki?) — ученица Токийского колледжа магии, член клана Дзенъин с Небесным ограничением.",
            rating = 4.6,
            power = 83,
            month = "Январь",
            day = "20",
            family = listOf(
                "Маи Дзенъин (сестра-близнец)",
                "Оги Дзенъин (отец)",
                "Клан Дзенъин",
            ),
            abilities = listOf(
                "Небесное ограничение",
                "Мастерство холодного оружия",
                "Усиленные физические способности",
            ),
            natureTypes = listOf(
                "Небесное ограничение"
            )
        ),
        Hero(
            id = 15,
            name = "Чосо",
            image = "/images/chosos.jpg",
            about = "Чосо (脹ちょう相そう Chōso?) — полупроклятый человек, старший из братьев Смертоносного узора, обладает техникой Кровавой манипуляции.",
            rating = 4.5,
            power = 84,
            month = "Неизвестно",
            day = "Неизвестно",
            family = listOf(
                "Эсо и Кечизу (младшие братья)",
                "Юдзи Итадори (брат по крови)",
            ),
            abilities = listOf(
                "Техника Кровавой манипуляции",
                "Сверхтекучесть",
                "Кровавый удар",
            ),
            natureTypes = listOf(
                "Техника Кровавой манипуляции"
            )
        )
    )

    override suspend fun getAllHeroes(page: Int): ApiResponse {
        return ApiResponse(
            success = true,
            message = "ok",
            heroes = heroes[page]!!,
            lastUpdater = System.currentTimeMillis(),
            nextPage = calculatePage(page = page)[NEXT_PAGE_KEY],
            prefPage = calculatePage(page = page)[PREVIOUS_PAGE_KEY]

        )
    }

    override suspend fun searchHeroes(name: String?): ApiResponse {
        return ApiResponse(
            success = true,
            message = "ok",
            heroes = findHeroes(query = name),
        )

    }

    private fun findHeroes (query: String? ) : List<Hero>{

        val foundedHeroes = mutableListOf<Hero>()

        return if (!query.isNullOrEmpty()) {
            heroes.forEach { (pageNumber, heroes ) ->
                    heroes.forEach { hero ->
                        if(hero.name.lowercase().contains(query.lowercase())){
                            foundedHeroes.add(hero)
                        }
                    }
            }
            foundedHeroes
        }else {
            emptyList()
        }

    }

    private fun calculatePage(page: Int) : Map<String, Int?> {
        var prefPage : Int? = page
        var nextPage : Int? = page

        if( page in 1..4) {
            nextPage = nextPage?.plus(1)
        }

        if( page in 2..5) {
            prefPage = prefPage?.minus(1)
        }

        if(page == 1) {
            prefPage = null
        }
        if(page == 5) {
            nextPage = null
        }


        return mapOf(
            PREVIOUS_PAGE_KEY to prefPage,
            NEXT_PAGE_KEY to nextPage
        )
    }

}