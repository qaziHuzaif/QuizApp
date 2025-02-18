package com.example.quizapp.data

import kotlin.random.Random

object Constants {
    const val USER_NAME = "username"
    const val TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"

    fun getQuestion(): ArrayList<Question> {
        // **General Knowledge Questions (5 Questions)**
        val generalKnowledgeQuestions = listOf(
            Question(
                1,
                "Who wrote 'Romeo and Juliet'?",
                "https://upload.wikimedia.org/wikipedia/commons/a/a2/Shakespeare.jpg",
                "William Shakespeare",
                "Charles Dickens",
                "Mark Twain",
                "Jane Austen",
                1
            ),
            Question(
                2,
                "Which planet is called the Red Planet?",
                "https://upload.wikimedia.org/wikipedia/commons/0/02/OSIRIS_Mars_true_color.jpg",
                "Jupiter",
                "Venus",
                "Mars",
                "Saturn",
                3
            ),
            Question(
                3,
                "What is the capital of Canada?",
                "https://upload.wikimedia.org/wikipedia/commons/b/b7/Parliament_Hill_2015.jpg",
                "Toronto",
                "Vancouver",
                "Ottawa",
                "Montreal",
                3
            ),
            Question(
                4,
                "Which is the longest river in the world?",
                "https://upload.wikimedia.org/wikipedia/commons/2/2e/Nile_River_and_delta_from_orbit.jpg",
                "Amazon River",
                "Nile River",
                "Yangtze River",
                "Mississippi River",
                2
            ),
            Question(
                5,
                "Who developed the theory of relativity?",
                "https://upload.wikimedia.org/wikipedia/commons/d/d3/Albert_Einstein_Head.jpg",
                "Isaac Newton",
                "Nikola Tesla",
                "Albert Einstein",
                "Galileo Galilei",
                3
            )
        )

        // **Science & Technology Questions (6 Questions)**
        val scienceQuestions = listOf(
            Question(
                1,
                "What is the chemical symbol for gold?",
                "https://upload.wikimedia.org/wikipedia/commons/5/50/Gold_crystals.jpg",
                "Ag",
                "Au",
                "Pb",
                "Fe",
                2
            ),
            Question(
                2,
                "What does DNA stand for?",
                "https://upload.wikimedia.org/wikipedia/commons/0/09/DNA_Structure%2BKey%2BLabelled.png",
                "Deoxyribonucleic Acid",
                "Dynamic Natural Algorithm",
                "Deoxynucleic Acid",
                "Dual Network Architecture",
                1
            ),
            Question(
                3,
                "Which part of the cell contains genetic material?",
                "https://upload.wikimedia.org/wikipedia/commons/4/41/Cell_structure.png",
                "Mitochondria",
                "Ribosomes",
                "Nucleus",
                "Cytoplasm",
                3
            ),
            Question(
                4,
                "What is the hardest natural substance?",
                "https://upload.wikimedia.org/wikipedia/commons/6/6e/Diamond1.jpg",
                "Gold",
                "Iron",
                "Diamond",
                "Platinum",
                3
            ),
            Question(
                5,
                "Which gas do plants absorb from the atmosphere?",
                "https://upload.wikimedia.org/wikipedia/commons/d/d3/Photosynthesis.png",
                "Oxygen",
                "Carbon Dioxide",
                "Nitrogen",
                "Hydrogen",
                2
            ),
            Question(
                6,
                "What is the speed of light?",
                "https://upload.wikimedia.org/wikipedia/commons/6/6f/Light_dispersion_conceptual.gif",
                "299,792 km/s",
                "150,000 km/s",
                "1,080 km/h",
                "3,000 km/s",
                1
            )
        )

        // **Sports Questions (5 Questions)**
        val sportsQuestions = listOf(
            Question(
                1,
                "Which country won the FIFA World Cup in 2018?",
                "https://upload.wikimedia.org/wikipedia/en/c/c3/Flag_of_France.svg",
                "Brazil",
                "Germany",
                "France",
                "Argentina",
                3
            ),
            Question(
                2,
                "Which sport uses a net, a shuttlecock, and a racket?",
                "https://upload.wikimedia.org/wikipedia/commons/1/12/Badminton_rackets.jpg",
                "Tennis",
                "Badminton",
                "Squash",
                "Table Tennis",
                2
            ),
            Question(
                3,
                "Who has won the most Olympic gold medals?",
                "https://upload.wikimedia.org/wikipedia/commons/8/8d/Michael_Phelps_Rio_Olympics_2016.jpg",
                "Usain Bolt",
                "Michael Phelps",
                "Simone Biles",
                "Carl Lewis",
                2
            ),
            Question(
                4,
                "Which NBA player is known as 'King James'?",
                "https://upload.wikimedia.org/wikipedia/commons/3/3f/LeBron_James_crop.jpg",
                "Kobe Bryant",
                "Stephen Curry",
                "LeBron James",
                "Kevin Durant",
                3
            ),
            Question(
                5,
                "What is the diameter of a basketball hoop in inches?",
                "https://upload.wikimedia.org/wikipedia/commons/3/3e/Basketball.png",
                "18 inches",
                "22 inches",
                "16 inches",
                "20 inches",
                1
            )
        )

        // **Flag Identification Questions (4 Questions)**
        val flagQuestions = listOf(
            Question(
                1,
                "Which country's flag is displayed?",
                "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/200px-Flag_of_Russia.svg.png",
                "Russia",
                "Ukraine",
                "Poland",
                "Czech Republic",
                1
            ),
            Question(
                2,
                "Identify this national flag.",
                "https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/200px-Flag_of_France.svg.png",
                "Germany",
                "France",
                "Italy",
                "Spain",
                2
            ),
            Question(
                3,
                "Which country's flag is shown here?",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9e/Flag_of_Japan.svg/200px-Flag_of_Japan.svg.png",
                "India",
                "China",
                "Japan",
                "South Korea",
                3
            ),
            Question(
                4,
                "This flag belongs to which country?",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Brazil.svg/200px-Flag_of_Brazil.svg.png",
                "Brazil",
                "Argentina",
                "Mexico",
                "Colombia",
                1
            )
        )

        // **Movies & Entertainment Questions (7 Questions)**
        val moviesQuestions = listOf(
            Question(
                1,
                "Which movie won Best Picture at the 2020 Oscars?",
                "https://upload.wikimedia.org/wikipedia/en/5/53/Parasite_%282019_film%29.png",
                "1917",
                "Joker",
                "Parasite",
                "Once Upon a Time in Hollywood",
                3
            ),
            Question(
                2,
                "Who played Iron Man in the MCU?",
                "https://upload.wikimedia.org/wikipedia/commons/0/0b/Robert_Downey_Jr_2014_Comic_Con_%28cropped%29.jpg",
                "Chris Evans",
                "Robert Downey Jr.",
                "Chris Hemsworth",
                "Tom Holland",
                2
            ),
            Question(
                3,
                "Which is the highest-grossing film ever?",
                "https://upload.wikimedia.org/wikipedia/en/f/fd/Avengers_Endgame_poster.jpg",
                "Titanic",
                "Avatar",
                "Avengers: Endgame",
                "Jurassic World",
                2
            ),
            Question(
                4,
                "Which character said 'I am your father'?",
                "https://upload.wikimedia.org/wikipedia/en/7/76/Darth_Vader.jpg",
                "Luke Skywalker",
                "Yoda",
                "Darth Vader",
                "Obi-Wan Kenobi",
                3
            ),
            Question(
                5,
                "Which actor has won the most Oscars?",
                "https://upload.wikimedia.org/wikipedia/commons/5/52/Katharine_Hepburn_1940s.jpg",
                "Meryl Streep",
                "Katharine Hepburn",
                "Jack Nicholson",
                "Robert De Niro",
                2
            ),
            Question(
                6,
                "Who directed 'Inception'?",
                "https://upload.wikimedia.org/wikipedia/commons/0/02/Christopher_Nolan_Cannes_2018.jpg",
                "Steven Spielberg",
                "James Cameron",
                "Christopher Nolan",
                "Quentin Tarantino",
                3
            ),
            Question(
                7,
                "Which movie features the song 'Let It Go'?",
                "https://upload.wikimedia.org/wikipedia/en/0/05/Frozen_%282013_film%29_poster.jpg",
                "Frozen",
                "Moana",
                "Tangled",
                "Coco",
                1
            )
        )

        // **List of all question sets**
        val allCategories = listOf(
            generalKnowledgeQuestions,
            scienceQuestions,
            sportsQuestions,
            flagQuestions,
            moviesQuestions
        )

        // **Randomly select a category**
        val selectedCategory = allCategories[Random.nextInt(allCategories.size)]

        // **Ensure IDs start from 1 in the selected category**
        return ArrayList(
            selectedCategory.mapIndexed { index, question ->
                question.copy(id = index + 1)
            }
        )
    }
}
