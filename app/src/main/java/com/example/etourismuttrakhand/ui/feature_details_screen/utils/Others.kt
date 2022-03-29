package com.example.etourismuttrakhand.ui.feature_details_screen.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.os.ParcelFileDescriptor.open
import androidx.viewpager2.widget.ViewPager2
import com.example.etourismuttrakhand.R
import com.example.etourismuttrakhand.ui.feature_details_screen.data.model.PlaceImage
import com.example.etourismuttrakhand.ui.features_favourite.data_source.entities.Place

object Others {

fun ViewPager2.autoScroll(interval: Long) {

    val handler = Handler()
    var scrollPosition = 0

    val runnable = object : Runnable {

        override fun run() {

            val count = adapter?.itemCount ?: 0
            setCurrentItem(scrollPosition++ % count, true)

            handler.postDelayed(this, interval)
        }
    }

    registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            scrollPosition = position+1
        }
    })

    handler.post(runnable)
}

    val charDham = listOf(
        PlaceImage(image = R.drawable.kedarnath,"Kedarnath"),
        PlaceImage(image = R.drawable.badri1,"Badrinath"),
        PlaceImage(image = R.drawable.gangotri4,"Gangotri"),
        PlaceImage(image = R.drawable.yamnotri1,"Yamnotri")
    )


fun Context.googleMap(name: String) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data =
        Uri.parse("https://www.google.com/maps/search/hotels+nearby+$name/@30.734085,79.0664363,18z")
    startActivity(intent)
}

fun Context.getHomeStay(id: Int) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data =
        Uri.parse("https://uttarakhandtourism.gov.in/accommodation?field_hotel_type_ws_value=homestay&field_destination_ws_target_id=$id")
    startActivity(intent)
}

val badrinath = listOf<Int>(
    R.drawable.badrinath1,
    R.drawable.badrinath2,
    R.drawable.badrinath3,
    R.drawable.badrinath4,
    R.drawable.badrinath5
)
val kedarnath = listOf<Int>(
    R.drawable.kedarnath10,
    R.drawable.kedarnath2,
    R.drawable.kedarnath4,
    R.drawable.kedarnath6,
    R.drawable.kedarnath8,
    R.drawable.kedarnath9
)
val dehradun = listOf(
    R.drawable.dehradun1,
    R.drawable.dehradun2,
    R.drawable.dehradun3,
    R.drawable.dehradun4,
    R.drawable.dehradun5,
    R.drawable.dehradun6
)
val auli = listOf(
    R.drawable.auli,
    R.drawable.auli2,
    R.drawable.auli3,
    R.drawable.auli4,
    R.drawable.auli5,
    R.drawable.auli6,
)
val gangotri = listOf(
    R.drawable.gangotri1,
    R.drawable.gangotri2,
    R.drawable.gangotri4,
    R.drawable.gangotri6
)
val haridwar = listOf(
    R.drawable.haridwar1,
    R.drawable.haridwar2,
    R.drawable.haridwar3,
    R.drawable.haridwar4,
    R.drawable.haridwar5,
    R.drawable.haridwar6
)
val yamnotri = listOf(
    R.drawable.yamnotri1,
    R.drawable.yamnotri2,
    R.drawable.yamnotri3,
    R.drawable.yamnotri4,
    R.drawable.yamnotri5,
    R.drawable.yamnotri6
)
val chopta = listOf(
    R.drawable.chopta1,
    R.drawable.chopta2,
    R.drawable.chopta3,
    R.drawable.chopta4,
    R.drawable.chopta5,
    R.drawable.chopta6
)

val bhimtal = listOf(R.drawable.bhimtal1, R.drawable.bhimtal2, R.drawable.bhimtal3)
val chakrata = listOf(R.drawable.chakrata1, R.drawable.chakrata2, R.drawable.chakrata3)
val chaukori = listOf(R.drawable.chaukori1, R.drawable.chaukori2, R.drawable.chaukori3)
val kausani = listOf(R.drawable.kausani1, R.drawable.kausani2, R.drawable.kausani3)
val nanital = listOf(
    R.drawable.nanital1,
    R.drawable.nanital2,
    R.drawable.nanital3,
    R.drawable.nanital4,
    R.drawable.nanital6
)
val mussoorie = listOf(
    R.drawable.mussoorie,
    R.drawable.mussoorie1,
    R.drawable.mussoorie2,
    R.drawable.mussoorie3,
    R.drawable.mussoorie4,
    R.drawable.mussoorie5,
)
val tehri = listOf(
    R.drawable.tehri,
    R.drawable.tehri2,
    R.drawable.tehri4,
    R.drawable.tehri5
)
val ranikhet = listOf(
    R.drawable.ranikhet3,
    R.drawable.ranikhet4,
    R.drawable.ranikhet5,
    R.drawable.ranikhet6
)

}

object Data {
    val kedarnath = Place(
        name = "kedarnath",
        image = Others.kedarnath,
        desc = "One of the most revered temple destinations of India, Kedarnath town is nestled in the mighty Garhwal Himalayas. The town, built around the revered Kedarnath temple, is located at an altitude of 3,580 m, near Chorabari glacier, which is the source of the Mandakini river. Dedicated to Lord Shiva, the ancient temple has exquisite architecture and is built of extremely large but evenly shaped grey stone slabs. A conical rock formation inside the temple is worshipped as Lord Shiva in his “Sadashiva” form.  The Kedarnath temple, dedicated to Lord Shiva, is a part of Char Dham pilgrimage circuit, and is one of the 12 Jyotirlingas of Lord Shiva in India. Behind the Kedarnath temple, stand the Kedarnath peak, Kedar Dome and other Himalayan peaks.\n" +
                "\n" +
                "The historical name of this region is \"Kedar Khand\" and legend says, the Pandavas from the epic Mahabharata, after having defeated the Kauravas, felt guilty of having killed so many people and sought the blessings of Lord Shiva for redemption. The Lord eluded them repeatedly and took refuge at Kedarnath in the form of a bull. The Lord dived into the ground, leaving his hump on the surface at Kedarnath. The remaining portions of Lord Shiva appeared at four other places and are worshipped there as his manifestations. The arms of the Lord appeared at Tungnath, the face at Rudranath, the belly at Madmaheshwar and his locks (hair) at Kalpeshwar. The Kedarnath and four above mentioned shrines make the revered Panch Kedar pilgrimage circuit. For booking a pilgrimage, visit https://badrinath-kedarnath.gov.in/common/kedarnath.",
        homeStayId = 153
    )
    val dehradun = Place(
        name = "dehradun",
        image = Others.dehradun,
        desc = "Fascinating history and intriguing mythology meet at the crossroads of this beautiful hill-station, one of the most popular in the country. Just 240 km from Delhi, nestled in the rolling Doon Valley and at the foothills of the Himalayas, Dehradun is surrounded by high mountains and lush Sal forests. Known for its pleasant year-round weather and scenic surroundings, the city is a gateway to several popular hill-stations like Mussoorie and pilgrimage sites like Haridwar and Rishikesh. \n" +
                "\n" +
                "Offering a blend of unparalleled landscape and modern amenities, bustling Dehradun is a city for both business and leisure. Once a retirement haven, today it buzzes with excitement, yet has managed to retain its laid-back vibe. Quaint cafés and lounges rub shoulders with heritage monuments and bazaars. \n" +
                "\n" +
                "The education hub of northern India, the city is home to iconic institutions like Welham and Doon School, alma mater of stalwarts like former Prime Minister Rajiv Gandhi, Olympian Abhinav Bindra, and renowned author Amitav Ghosh. The Indian Military Academy is also located here. Said to have been established by Sikh guru Ram Rai in 1675, the city is also known as the abode of Dronacharya, the famed teacher from the epic Mahabharata. Fascinating history and intriguing mythology meet at the crossroads of this beautiful town, one of the most popular vacation spots in the country. ",
        homeStayId = 77
    )
    val auli = Place(
        name = "auli",
        image = Others.auli,
        desc = "    val auli = Place (name = \"auli\", image = auli, desc=\"\")\n",
        homeStayId = 56
    )
    val gangotri = Place(
        name = "gangotri",
        image = Others.gangotri,
        desc = "One of the char dhams (the most sacred pilgrimage circuits in northern India with four holy destinations), Gangotri, in Uttarkashi, is a small town with the temple of Goddess Ganga at its heart. A 12-hour drive from Rishikesh, Gangotri is nestled among lofty Garhwal Himalayan peaks, glaciers and dense forests, and is one of highest pilgrimages in India (approx 3,415 m). Other than its divine atmosphere, Gangotri offers stunning vistas all around. According to Hindu legends, the most sacred of all rivers, Ganges (or Ganga), descended from heaven to earth at Gangotri, when Lord Shiva released the mighty river from his locks. The actual origin of the river is at Gaumukh in the Gangotri glacier, 19 km away from Gangotri and is accessible by trekking. After it originates from Gaumukh, the river is known as Bhagirathi and it acquires the name 'Ganga' after the river Alaknanda merges into it near the town of Devaprayag.",
        homeStayId = 62
    )
    val haridwar = Place(
        name = "haridwar",
        image = Others.haridwar,
        desc = "One of the holiest pilgrimages in India, Haridwar, or the ‘gateway to gods’, is located where Ganga, the sacredest of all Indian rivers, enters the Indo-Gangetic plains. Located at the foothills of the Himalayas, Haridwar is a city of temples and ashrams and its pious ambience envelops everyone. Haridwar is one of the four holy Indian cities that host the Kumbh Mela, a pious gathering of millions of Hindu devotees every 12 years. The Ardh Kumbh is organised here every six years. It also hosts the Kanwar mela every year during the rainy season. The ‘Panch Tirth’ or the five pilgrimages located within the periphery of Haridwar, are Gangadwara (Har Ki Pauri), Kushwart (Ghat), Kankhal, Bilwa Tirtha (Mansa Devi Temple) and Neel Parvat (Chandi Devi). Haridwar serves as the gateway to the Char Dham of Uttarakhand as well. ",
        homeStayId = 80
    )

    //val yamnotri = Place (name ="yamnotri", image =yamnotri, desc="amunotri is a part of Char Dham (along with Gangotri, Kedarnath and Badrinath), the four most revered Hindu pilgrimages in the Himalayas. The small mountain hamlet, with the Yamunotri Temple at its centre, attracts thousands of devotees every year and is the commencing point of the Char Dham Yatra pilgrimage (May to October), which proceeds from Yamunotri to Gangotri and finally to Kedarnath and Badrinath. Lodged in a narrow gorge, close to the source of the Yamuna, the Yamunotri Temple is dedicated to Yamuna, the second-most sacred river after the Ganges. A dip in River Yamuna is said to protect one from untimely death.  Devotees either walk or ride a palanquin or a pony to reach the temple (around 3,233 m above sea level) from Janki Chatti, a steep trek of about 3 km that takes about 3 hours. \n",homeStayId = )
    val chopta = Place(
        name = "chopta",
        image = Others.chopta,
        desc = "Popularly referred to as the ‘mini Switzerland’ of Uttarakhand, Chopta (at an approximate altitude of 2,608 m) is a slice of paradise tucked away in the Garhwal Himalayas. Surrounded by bugyals or velvety meadows and pristine snow-capped peaks, Chopta is an all-year holiday destination: pleasant in summer, rain-fresh in monsoon and a snow-clad fairyland in winter. Chopta is at the epicentre of the Panch Kedar – the five most sacred Shiva temples in the state. On its left are located Kedarnath and Madmaheshwar shrines and on the right, Rudranath and Kalpeshwar, and just above it, the Tungnath temple. Chopta is a birding paradise and you can see over 240 species of birds here, including native and migratory species like Himalayan monal, Himalayan swiftlet, Himalayan griffon, scarlet finch, hill partridge, and so on. Nearby places like Dugalbitta, Mandal village, Makkumath and the Tungnath trek route are the best sites for watching our feathered friends. Chopta has been declared as an important bird-watching site by national and international conservation and biodiversity organisations.",
        homeStayId = 76
    )

    //    val hemkund = Place(
//        name = "hemkund",
//        image = Others.hemkund,
//        desc = "This beautiful gurudwara, also known as Gurudwara Shri Hemkund Sahib Ji, is situated at an altitude of around 4,329 m, on the bank of the pristine Hemkund (Lokpal) lake at the base of the Saptshringi glacier. One of the most revered Sikh shrines, Hemkund Sahib draws thousands of pilgrims every year. It is recorded in the holy Granth Sahib that the tenth guru of Sikhs, Guru Govind Singh, mediated by the serene banks of Hemkund lake in one of his earlier births. Surrounded by seven snow-capped peaks, the gurudwara's picturesque natural settings and trek routes, including the one to the Valley of Flowers, make it a popular destination for trekkers and tourists as well. You can reach this majestic lake through a challenging trek from Ghangharia. A small stream known as Himganga originates from the imposing Hemkund lake.\n" +
//                "\n" +
//                "It is said Lakshmana, younger brother of Lord Rama from the epic Ramayana, regained his health by meditating on the banks of Hemkund after the severe injuries he received in the war. The Lakshmana temple is said to have been built at the place where Lakshmana meditated."
//    )
    val bhimtal = Place(
        name = "bhimtal",
        image = Others.bhimtal,
        desc = "Bhimtal, another lake town adjoining the popular hill-station Nainital, is an idyllic vacation spot. In monsoon, the lake fills up to the brim and makes for a beautiful picture set against the green hills. Dotted with pretty houses along the slopes, Bhimtal is perfect for a serene holiday. In winters, Bhimtal becomes a bird-watchers paradise, with the arrival of migratory birds. \n" +
                "\n" +
                "Legends say that Bhima, one of the Pandava princes from Mahabharata, created the picturesque lake and hence, its name. Historians believe that Bhimtal was used as a stoppage en route to Nepal and Tibet from India and may have been a part of the ancient silk route. The town is also home to several educational institutions.",
        homeStayId = 50
    )
    val chakrata = Place(
        name = "chakrata",
        image = Others.chakrata,
        desc = "Nestled amidst lush conifers, flaming red rhododendrons, towering oaks and the mighty snowy Himalayan ranges, Chakrata is one of Uttarakhand's veritable treasures. Situated about 88 km from Dehradun and perched at a height of about 7,000 m above sea level, Chakrata served as the summer retreat for high ranking officials of the East India Company during the British Raj.\n" +
                "\n" +
                "Chakrata, with its laid-back yet pleasant ambiance, offers a sweeping view of the Yamuna Valley below. There are a few quaint tree-lined paths that visitors can explore. For those looking for snowy adventure, the Kharamba Peak awaits. At around 10,000 m above sea level, it is one of the highest of its kind in the area. Visitors can also partake in skiing in Chakrata's northern slopes.",
        homeStayId = 53
    )
    val chaukori = Place(
        name = "chaukori",
        image = Others.chaukori,
        desc = "Surrounded towering Himalayan peaks and lush forests, Chaukori is an idyllic tourist destination. It is replete with snow-capped mountains, verdant valleys, deodar and rhododendrons, and picturesque views as far as the eye can go. The stunning Panchachuli peaks are visible from this paradisiacal location. Located at a height of around 2,010 m, and about 173 km away from Nainital, Chaukori hosts large stretches of emerald tea gardens, which make for excellent nature walks. Don't forget to explore the fruit orchards here. Also, don't miss the fabulous sunrises and sunsets that you are treated to.",
        homeStayId = 75
    )
    val kausani = Place(
        name = "kausani",
        image = Others.kausani,
        desc = "The ideal way to explore this picturesque hill-station is to come without a plan. You can spend an entire day just watching the magical play of colours on the mountain peaks surrounding Kausani. This village, perched on a ridge covered with chir and blue pine forests, is most well-known for the spectacular panoramic view of the Himalayan peaks like Trishul, Nanda Devi, and the mighty Panchachuli. Enjoy a picture-perfect sunrise from one of the many viewing platforms in the village. As the sun peeps above the horizon, the snow-crested peaks take on every hue of the rising golden orb. \n" +
                "\n" +
                "Or you can explore the surrounding forests, filled with babbling creeks, chirping birds and serenity. A paradise for bird lovers, here you can spot more than 50 different species of birds such as woodpecker, barbet, parakeet, robin and fork tail. The Kausani Tea Estate is an apt location to spot birds. The Hrithik Roshan-starrer movie Koi Mil Gaya (2003) was mostly shot in Nainital, Bhimtaal and Kausani. ",
        homeStayId = 85
    )
    val nanital = Place(
        name = "nanital",
        image = Others.nanital,
        desc = "Nainital, the charming Himalayan lake town, is a picture-postcard perfect hill-station and one of the most popular in Northern India. Commonly known as the ‘Lake District’, Nainital is nestled high up in the Kumaon Himalayas at an altitude of around 2,000 m above sea level. This beautiful town in surrounded by seven hills, popularly known as ‘Sapta-Shring’ – Ayarpata, Deopata, Handi-Bandi, Naina, Alma, Lariya-Kanta and Sher-Ka-Danda. The majestic mountains and the sparkling waters of the lake add an immense lot to the beauty of the town.  The town is centred around the emerald mountain lake Naini, which on most days is dotted with colourful sailboats. According to mythology, the lake is believed to have been formed when the eyes of goddess “Sati” fell at this spot while her body was being carried by Lord Shiva after her death.",
        homeStayId = 106
    )

    val dataSource = listOf(nanital, dehradun, kausani, haridwar, auli, chakrata)

}
