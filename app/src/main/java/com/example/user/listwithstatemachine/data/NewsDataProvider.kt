package com.example.user.listwithstatemachine.data

import com.example.user.listwithstatemachine.entity.News
import java.util.*

class NewsDataProvider : DataProvider<News> {
    override fun provide(): MutableList<News> {
        val data = mutableListOf<News>()
        data.add(News(
                "Amazon Alexa goes AWOL for many users",
                "Some Amazon  Alexa users are currently having problems reaching the voice assistant. Instead of reacting to commands, Alexa simply says “sorry, something went wrong.” Amazon hasn’t commented publicly yet on the issue.\n" +
                        "\n" +
                        "Based on tweets and Down Detector, users began having trouble reaching Alexa around 7AM PST. While some had their connection issues resolved quickly, many others are still waiting.",
                Date()))
        data.add(News("2019 Audi R8 looks refreshed and sharper than ever",
                "The Audi R8 V10 is an easy car to love. It's handsome, sounds incredible, and in supercar terms, it's relatively affordable to own, reliable and actually makes for a pretty reasonable daily driver. Audi probably could've soldiered on with the R8 as it is for a couple more years without garnering too many complaints. Not content to rest on its laurels, the company announced Tuesday that its mid-engined missile is getting some tweaks.",
                Date()
        ))
        data.add(News("Apple Highlights iPhone XR Reviews",
                "Reviews for the iPhone XR went live this morning ahead of Friday's launch, and in a press release in the Apple Newsroom, Apple has highlighted reviews from several members of the media who were able to spend some time with the new iPhones. \n" +
                        "\n" +
                        "Apple shared key passages from sites that include Digital Trends, Daring Fireball, Tom's Guide, Mashable, Engadget, The Verge, TechCrunch, CNN, Best Products, Techradar, and more.",
                Date()))
        data.add(News("Stardew Valley now available on iPhone and iPad for \$7.99",
                "As announced earlier this month, the popular farming RPG Stardew Valley is now available for iOS. The game is a \$7.99 download on the App Store, and is optimized for both iPhone and iPad." +
                        "Stardew Valley creator Eric Barone promises that the version of Stardew Valley for iOS is the “full game, not a cut down version” like some PC games are when they make their way to iOS.",
                Date()
        ))
        data.add(News("The Pixel 3 Won't Wirelessly Charge at Max Speed Except on Google-Approved Chargers", "If you’re considering getting one of Google’s new Pixel 3 devices, beware: Unless you use a Google-certified accessory, wireless fast charging will only work at half of the phone’s maximum 10 watt charging speed.\n" +
                "Per reports in Android Police and the Verge, unapproved models of wireless fast chargers will only work at 5 watt speed with the Pixel 3 line, despite it supporting the Qi open wireless power transfer standard used by other manufacturers. Android Police wrote that Google told them the Pixel 3 line requires a “secure handshake” when using the company’s Pixel Stand to charge at 10 watts, and the method involved isn’t supported by other chargers—and the full 10-watt charging mode will only be enabled for third-party chargers approved via its Made for Google program. " +
                "Making things somewhat more confusing, Android Police noted that the Pixel 3 still displays a message saying “charging rapidly” when it’s connected to a third-party device charging at the lesser speed.",
                Date()))
        data.add(News("More Alexa-enabled headphones might be on the way with Qualcomm Bluetooth chips",
                "Some Alexa-enabled headphones already exist, but Qualcomm wants to make it easier for hardware makers to build Amazon’s assistant into their devices and use Qualcomm chips while doing so. The company released a reference design today that’ll give makers the instructions on how to make an Alexa-enabled device with a button to activate the assistant. Of course, the design incorporates Qualcomm’s Bluetooth audio chips.\n" +
                        "\n" +
                        "Qualcomm’s goal is to make it simpler for creators to build a device without having to think too much about the Alexa code or hardware sourcing. It’s a simple solution that the company hopes will recruit new customers by encouraging them to buy Qualcomm’s Bluetooth chips to get Alexa.",
                Date()))
        data.add(News("Facebook announces overhauled, simplified Messenger app",
                "Facebook’s Messenger app is going back to basics in its new redesign.\n" +
                        "\n" +
                        "The company announced the layout change, dubbed “Messenger 4,” on Tuesday, with the hope of boosting consumer satisfaction. Stan Chudnovsky, vice president of Facebook Messenger, made the announcement in a blog post, touting the simpler design.\n" +
                        "\n" +
                        "Chudnovsky stated the layout “put the focus back on messaging and connecting.”",
                Date()))
        data.add(News("Why HTC is Only Accepting Bitcoin and Ethereum for its First Blockchain Phone",
                "The primary feature of the Exodus 1 is its security. It has been developed to operate as a hardware cryptocurrency wallet, allowing users to safely store digital assets in the local wallet of the phone.\n" +
                        "\n" +
                        "In July, Samsung, the largest electronics manufacturer in Asia, revealed that mobile phones are significantly more secure in processing cryptocurrency payments than alternative devices and platforms such as desktop and the web because of the existence of a trusted ecosystem called the Trusted Execution Environment (TEE).",
                Date()))

        return data
    }
}