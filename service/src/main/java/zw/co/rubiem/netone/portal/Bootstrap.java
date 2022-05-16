package zw.co.rubiem.netone.portal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import zw.co.rubiem.netone.portal.product.Product;
import zw.co.rubiem.netone.portal.product.ProductDao;
import zw.co.rubiem.netone.portal.product.category.ProductCategory;
import zw.co.rubiem.netone.portal.product.category.ProductCategoryDao;

@Profile("winds")
//@Component
public class Bootstrap implements CommandLineRunner {

    private final ProductDao productDao;
    private final ProductCategoryDao productCategoryRepository;

    public Bootstrap(ProductDao productDao, ProductCategoryDao productCategoryRepository) {
        this.productDao = productDao;
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        ProductCategory data = new ProductCategory();
        data.setName("Data");
        data.setDescription("Data");
        if (!productCategoryExists("Data"))
            productCategoryRepository.save(data);

        ProductCategory voice = new ProductCategory();
        voice.setName("Voice");
        voice.setDescription("Voice");
        if (!productCategoryExists("Voice"))
            productCategoryRepository.save(voice);

        ProductCategory sms = new ProductCategory();
        sms.setName("SMS");
        sms.setDescription("SMS");
        if (!productCategoryExists("SMS"))
            productCategoryRepository.save(sms);

        ProductCategory vas = new ProductCategory();
        vas.setName("VAS");
        vas.setDescription("VAS");
        if (!productCategoryExists("VAS"))
            productCategoryRepository.save(vas);

        Product whatsapp = new Product();
        whatsapp.setTitle("Whatsapp");
        whatsapp.setShortDescription("In a world increasingly driven by data and connectivity, the need for broadband solutions has never been higher. Whatsapp is our answer to that need. Under the Whatsapp Banner we offer daily, weekly and monthly prepaid data bundles.");
        whatsapp.setImageUrl("https://nyax-file-storage.herokuapp.com/v1/files/download/1652644635151-nwb007.jpg");
        whatsapp.setProductCategory(data);
        if (!productExists("Whatsapp"))
            productDao.save(whatsapp);

        Product oneFusion = new Product();
        oneFusion.setTitle("One Fusion");
        oneFusion.setShortDescription("OneFusion is an ALL-IN-ONE package that gives you the MOST voice calls, data, SMS and social media access at an affordable price. Take control, NO cost surprises with OneFusion. Select the plan that best works for you and enjoy the discounted tariffs.");
        oneFusion.setImageUrl("https://nyax-file-storage.herokuapp.com/v1/files/download/1652644697745-onefusion.jpg");
        oneFusion.setProductCategory(data);
        if (!productExists("One Fusion"))
            productDao.save(oneFusion);

        Product voiceBundles = new Product();
        voiceBundles.setTitle("Voice Bundles");
        voiceBundles.setShortDescription("Enjoy calling across any local network with Khuluma 24/7 or to another NetOne number for less with The One The Only. Dial *171# to activate Khuluma 24/7 or Dollar-A-Day and stay connected with the best voice bundles in Zimbabwe.");
        voiceBundles.setImageUrl("https://nyax-file-storage.herokuapp.com/v1/files/download/1652645666868-khuluma.jpg");
        voiceBundles.setProductCategory(voice);
        if (!productExists("Voice Bundles"))
            productDao.save(voiceBundles);

        Product dollarAday = new Product();
        dollarAday.setTitle("Dollar A Day");
        dollarAday.setShortDescription("Enjoy calling across any local network with Khuluma 24/7 or to another NetOne number for less with The One The Only. Dial *171# to buy Dollar-A-Day bundle. and stay connected via voice and sms.");
        dollarAday.setImageUrl("https://nyax-file-storage.herokuapp.com/v1/files/download/1652645750343-dholaday.jpg");
        dollarAday.setProductCategory(voice);
        if (!productExists("Dollar A Day"))
            productDao.save(dollarAday);

        Product smsBundles = new Product();
        smsBundles.setTitle("SMS Bundles");
        smsBundles.setShortDescription("Send messages across all networks in Zimbabwe for so much less. All you have to do is dial *171# and select option 3 to purchase the SMS bundle of your choice.");
        smsBundles.setImageUrl("https://nyax-file-storage.herokuapp.com/v1/files/download/1652645837565-nwb006.jpg");
        smsBundles.setProductCategory(sms);
        if (!productExists("SMS Bundles"))
            productDao.save(smsBundles);

        Product easyCredit = new Product();
        easyCredit.setTitle("Easy Credit");
        easyCredit.setShortDescription("Get airtime credit for those emergency situations with #EasyCredit To access the service your SIM card needs to have been active for more than 2 months, and you need to be recharging $ 2 or more per month.");
        easyCredit.setImageUrl("https://nyax-file-storage.herokuapp.com/v1/files/download/1652645925722-easycredit.jpg");
        easyCredit.setProductCategory(vas);
        if (!productExists("Easy Credit"))
            productDao.save(easyCredit);

        Product roaming = new Product();
        roaming.setTitle("Roaming");
        roaming.setShortDescription("Stay connected anywhere in the world while you travel with OneGlobal. NetOne offers travellers the widest coverage with the most affordable rates. Choose NetOne for seamless voice, data and SMS services, anywhere! To activate OneGlobal SMS ROAMON to 34444.");
        roaming.setImageUrl("https://nyax-file-storage.herokuapp.com/v1/files/download/1652646106172-roaming.jpg");
        roaming.setProductCategory(vas);
        if (!productExists("Roaming"))
            productDao.save(roaming);

        Product one4Cash = new Product();
        one4Cash.setTitle("One4Cash");
        one4Cash.setShortDescription("Play and win with One4Cash. Join thousands of players across Zimbabwe who are playing One4Cash and stand a chance to win ZWL $2 000 every week! SMS \"PLAY\" to 423 and start playing now!");
        one4Cash.setImageUrl("https://nyax-file-storage.herokuapp.com/v1/files/download/1652646177450-one4cash1.jpg");
        one4Cash.setProductCategory(vas);
        if (!productExists("One4Cash"))
            productDao.save(one4Cash);

        Product instaWin = new Product();
        instaWin.setTitle("InstaWin");
        instaWin.setShortDescription("Play InstaWin and win instant cash prizes that will put a little extra spending money in your pocket. SMS 'WIN' to 374 now and start playing.");
        instaWin.setImageUrl("https://nyax-file-storage.herokuapp.com/v1/files/download/1652646246885-instawin.jpg");
        instaWin.setProductCategory(vas);
        if (!productExists("InstaWin"))
            productDao.save(instaWin);

    }

    boolean productCategoryExists(String name) {
        return productCategoryRepository.findByNameIgnoreCase(name).isPresent();
    }

    boolean productExists(String name) {
        return productDao.findByTitleIgnoreCase(name).isPresent();
    }

}