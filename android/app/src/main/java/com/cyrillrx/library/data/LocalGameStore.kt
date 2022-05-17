package com.cyrillrx.library.data

import com.cyrillrx.library.model.Game
import kotlin.time.Duration.Companion.minutes

class LocalGameStore {
    fun fetch(): List<Game> = GAMES

    companion object {
        private val GAMES = listOf(
            Game(
                name = "Oriflamme - Embrasement",
                description = "La course au trône est lancé ! Le temps n'est plus aux intrigues discrètes, la guerre est ouverte ! Votre famille est plus puissante que jamais et votre but est à portée de main.",
                age = 10,
                duration = 20.minutes,
                playerCount = Game.PlayerCount(3, 5),
                imageUrls = listOf(
                    "https://cdn2.philibertnet.com/496226-thickbox_default/oriflamme-embrasement.jpg",
                    "https://cdn3.philibertnet.com/476339-thickbox_default/oriflamme-embrasement.jpg",
                    "https://cdn2.philibertnet.com/496224-thickbox_default/oriflamme-embrasement.jpg",
                    "https://cdn1.philibertnet.com/496225-thickbox_default/oriflamme-embrasement.jpg",
                ),
                releasedAt = "2020-10-01",
                acquiredAt = "2022-03-28",
            ),
            Game(
                name = "7 Wonders : Architects",
                description = "7 Wonders Architects est un nouveau jeu dans le monde de 7 Wonders. Conçu pour une expérience de jeu fluide et immersive, Architects propose une mécanique légèrement simplifiée, mais qui conserve la profondeur stratégique pour laquelle la marque 7 Wonders est si bien connue.",
                age = 8,
                duration = 25.minutes,
                playerCount = Game.PlayerCount(2, 7),
                imageUrls = listOf(
                    "https://cdn3.philibertnet.com/515898-thickbox_default/7-wonders-architects.jpg",
                    "https://cdn2.philibertnet.com/515899-thickbox_default/7-wonders-architects.jpg",
                    "https://cdn2.philibertnet.com/515900-thickbox_default/7-wonders-architects.jpg",
                    "https://cdn1.philibertnet.com/518644-thickbox_default/7-wonders-architects.jpg",
                ),
                releasedAt = "2021-10-01",
                acquiredAt = "2022-03-28",
            ),
            Game(
                name = "The Mind - NatureLine",
                description = "Retrouvez The Mind dans sa version durable. The Mind est plus qu'un simple jeu. C'est une expérience, un voyage, totalement simple et l'expérience d'équipe la plus ingénieuse que vous puissiez vivre.",
                age = 8,
                duration = 20.minutes,
                playerCount = Game.PlayerCount(2, 4),
                imageUrls = listOf(
                    "https://cdn1.philibertnet.com/516230-thickbox_default/the-mind-natureline.jpg",
                    "https://cdn1.philibertnet.com/516231-thickbox_default/the-mind-natureline.jpg",
                    "https://cdn2.philibertnet.com/516232-thickbox_default/the-mind-natureline.jpg",
                    "https://cdn2.philibertnet.com/516233-thickbox_default/the-mind-natureline.jpg",
                ),
                releasedAt = "2018-02-01",
                acquiredAt = "2022-03-28",
            ),
            Game(
                name = "Happy City",
                description = "Bâtissez votre ville et mettez-y du cœur ! Cherchez les bonnes tactiques pour gérer vos revenus, faire venir des habitants et les rendre heureux. Créez un petit paradis plus attirant que les villes adverses !",
                age = 10,
                duration = 30.minutes,
                playerCount = Game.PlayerCount(2, 5),
                imageUrls = listOf(
                    "https://cdn3.philibertnet.com/495702-thickbox_default/happy-city.jpg",
                    "https://cdn3.philibertnet.com/495703-thickbox_default/happy-city.jpg",
                    "https://cdn3.philibertnet.com/495704-thickbox_default/happy-city.jpg",
                    "https://cdn1.philibertnet.com/495705-thickbox_default/happy-city.jpg",
                ),
                releasedAt = "2021-04-01",
                acquiredAt = "2022-03-28",
            ),
            Game(
                name = "Top Ten",
                description = "Top Ten est un jeu coopératif innovant et drôle comprenant 500 thèmes variés et délirants qui vous feront inventer, raconter et mimer n’importe quoi !",
                age = 14,
                duration = 30.minutes,
                playerCount = Game.PlayerCount(4, 9),
                imageUrls = listOf(
                    "https://cdn3.philibertnet.com/472412-thickbox_default/top-ten.jpg",
                    "https://cdn3.philibertnet.com/472413-thickbox_default/top-ten.jpg",
                    "https://cdn3.philibertnet.com/472414-thickbox_default/top-ten.jpg",
                    "https://cdn1.philibertnet.com/482763-thickbox_default/top-ten.jpg",
                ),
                releasedAt = "2020-07-01",
                acquiredAt = "2022-03-28",
            ),
            Game(
                name = "Codenames",
                description = "Codenames est un jeu de langage et de déduction dans lequel s'affrontent deux équipes d'espions. À leur tête, deux maîtres de l'espionnage rivaux sont les seuls à connaître les identités secrètes des 25 agents.",
                age = 12,
                duration = 15.minutes,
                playerCount = Game.PlayerCount(2, 8),
                imageUrls = listOf(
                    "https://cdn3.philibertnet.com/353015-thickbox_default/codenames-vf.jpg",
                    "https://cdn3.philibertnet.com/353016-thickbox_default/codenames-vf.jpg",
                    "https://cdn2.philibertnet.com/353017-thickbox_default/codenames-vf.jpg",
                ),
                releasedAt = "2016-07-01",
                acquiredAt = "2022-03-28",
            ),
        )
    }
}
