package zw.co.afrosoft.telone.insurance.service.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import zw.co.afrosoft.telone.insurance.commons.utils.RandomUtils;
import zw.co.afrosoft.telone.insurance.domain.collectionpoint.Country;
import zw.co.afrosoft.telone.insurance.domain.currency.Currency;
import zw.co.afrosoft.telone.insurance.domain.insurancetype.ProductType;
import zw.co.afrosoft.telone.insurance.domain.payment.paymentmethods.PaymentMethod;
import zw.co.afrosoft.telone.insurance.domain.product.Product;
import zw.co.afrosoft.telone.insurance.persistence.city.CityRepository;
import zw.co.afrosoft.telone.insurance.persistence.country.CountryRepository;
import zw.co.afrosoft.telone.insurance.persistence.currency.CurrencyRepository;
import zw.co.afrosoft.telone.insurance.persistence.insurancetype.ProductTypeRepository;
import zw.co.afrosoft.telone.insurance.persistence.payments.paymentmethod.PaymentMethodRepository;
import zw.co.afrosoft.telone.insurance.persistence.product.ProductRepository;
import zw.co.afrosoft.telone.insurance.service.utils.FileUploadUtils;


@Component
public class Bootstrap implements CommandLineRunner {

    private final PaymentMethodRepository paymentMethodRepository;
    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final CurrencyRepository currencyRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final FileUploadUtils fileUploadUtils;


    public Bootstrap(PaymentMethodRepository paymentMethodRepository, ProductRepository productRepository, ProductTypeRepository productTypeRepository, CurrencyRepository currencyRepository, CountryRepository countryRepository, CityRepository cityRepository, FileUploadUtils fileUploadUtils, FileUploadUtils fileUploadUtils1) {
        this.paymentMethodRepository = paymentMethodRepository;
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.currencyRepository = currencyRepository;
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.fileUploadUtils = fileUploadUtils;
    }

    @Override
    public void run(String... args) throws Exception {

        ProductType motor = new ProductType();
        motor.setActive(true);
        motor.setName("Motor Vehicle Insurance");
        motor.setDeleted(false);
        motor.setDescription("Motor Vehicle  Insurance");
        if (!productTypeExists("Motor Vehicle Insurance"))
            productTypeRepository.save(motor);

        ProductType life = new ProductType();
        life.setActive(true);
        life.setName("Life Insurance");
        life.setDeleted(false);
        life.setDescription("Life Insurance");
        if (!productTypeExists("Life Insurance"))
            productTypeRepository.save(life);

        ProductType health = new ProductType();
        health.setActive(true);
        health.setDeleted(false);
        health.setName("Health Insurance");
        health.setDescription("Health Insurance");
        if (!productTypeExists("Health Insurance"))
            productTypeRepository.save(health);

        ProductType residentialBuilding = new ProductType();
        residentialBuilding.setActive(true);
        residentialBuilding.setName("Residential Building Insurance");
        residentialBuilding.setDescription("Residential Building Insurance");
        if (!productTypeExists("Residential Building Insurance"))
            productTypeRepository.save(residentialBuilding);

        ProductType commercialBuilding = new ProductType();
        commercialBuilding.setActive(true);
        commercialBuilding.setDeleted(false);
        commercialBuilding.setName("Commercial Building Insurance");
        commercialBuilding.setDescription("Commercial Building Insurance");
        if (!productTypeExists("Commercial Building Insurance"))
            productTypeRepository.save(commercialBuilding);

        ProductType travel = new ProductType();
        travel.setActive(true);
        travel.setDeleted(false);
        travel.setName("Travel Insurance");
        travel.setDescription("Travel Insurance");
        if (!productTypeExists("Travel Insurance"))
            productTypeRepository.save(travel);

        Product thirdParty = new Product();
        thirdParty.setDescription("Third Party Only");
        thirdParty.setName("Basic Third Party");
        thirdParty.setCode(RandomUtils.generateTokenWithSeed(thirdParty.getName()));
        thirdParty.setProductType(motor);
        thirdParty.setDeleted(false);
        thirdParty.setActive(true);
        if (!productExists("Basic Third Party"))
            productRepository.save(thirdParty);


        Product fullThirdParty = new Product();
        fullThirdParty.setDescription("Full Third Party");
        fullThirdParty.setName("Full Third Party");
        fullThirdParty.setCode(RandomUtils.generateTokenWithSeed(fullThirdParty.getName()));
        fullThirdParty.setActive(true);
        fullThirdParty.setDeleted(false);
        fullThirdParty.setProductType(motor);
        if (!productExists("Basic Third Party"))
            productRepository.save(fullThirdParty);

        Product fullThirdPartyFireTheft = new Product();
        fullThirdPartyFireTheft.setDescription("Full Third Party, Fire And Theft");
        fullThirdPartyFireTheft.setName("Full Third Party, Fire And Theft");
        fullThirdPartyFireTheft.setCode(RandomUtils.generateTokenWithSeed(fullThirdPartyFireTheft.getName()));
        fullThirdPartyFireTheft.setActive(true);
        fullThirdPartyFireTheft.setDeleted(false);
        fullThirdPartyFireTheft.setProductType(motor);
        if (!productExists("Full Third Party, Fire And Theft"))
            productRepository.save(fullThirdPartyFireTheft);

        Product comprehensive = new Product();
        comprehensive.setDescription("Comprehensive");
        comprehensive.setName("Comprehensive");
        comprehensive.setCode(RandomUtils.generateTokenWithSeed(comprehensive.getName()));
        comprehensive.setActive(true);
        comprehensive.setDeleted(false);
        comprehensive.setProductType(motor);
        if (!productExists("Comprehensive"))
            productRepository.save(comprehensive);

        Product rta = new Product();
        rta.setDescription("Road Traffic Act");
        rta.setName("Road Traffic Act");
        rta.setCode(RandomUtils.generateTokenWithSeed(rta.getName()));
        rta.setActive(true);
        rta.setDeleted(false);
        rta.setProductType(motor);
        if (!productExists("Road Traffic Act"))
            productRepository.save(rta);

        Country country = new Country("Zimbabwe", "ZWE");
        if (countryRepository.findByNameIgnoringCase("Zimbabwe").isEmpty())
            countryRepository.save(country);

//        City city = new City("Shurugwi", "Sh");
//        if (cityRepository.findByNameIgnoringCase("Shurugwi").isEmpty())
//            cityRepository.save(city);
//
//        Country country1 = new Country("Zimbabwe", "ZWE");
//        if (countryRepository.findByNameIgnoringCase("Zimbabwe").isEmpty())
//            countryRepository.save(country1);
//
//        City city1 = new City("Harare", "Hr");
//        if (cityRepository.findByNameIgnoringCase("Harare").isEmpty())
//            cityRepository.save(city1);
//
//        Country country2 = new Country("Zimbabwe", "ZWE");
//        if (countryRepository.findByNameIgnoringCase("Zimbabwe").isEmpty())
//            countryRepository.save(country2);
//
//        City city2 = new City("Masvingo", "Ms");
//        if (cityRepository.findByNameIgnoringCase("Gaborone").isEmpty())
//            cityRepository.save(city2);
//
//        Country country3 = new Country("Zimbabwe", "ZWE");
//        if (countryRepository.findByNameIgnoringCase("Zimbabwe").isEmpty())
//            countryRepository.save(country3);

//        City city3 = new City("Mutare", "Mt");
//        if (cityRepository.findByNameIgnoringCase("Mutare").isEmpty())
//            cityRepository.save(city3);

//        Product lifePackage = new Product();
//        lifePackage.setActive(true);
//        lifePackage.setName("Life Insurance");
//        lifePackage.setDescription("Life Insurance");
//        lifePackage = productRepository.save(lifePackage);
//
//        Product healthPackage = new Product();
//        healthPackage.setActive(true);
//        healthPackage.setName("Health Insurance");
//        healthPackage.setDescription("Health Insurance");
//        healthPackage = productRepository.save(healthPackage);
//
//        Product residentialBuildingPackage = new Product();
//        residentialBuildingPackage.setActive(true);
//        residentialBuildingPackage.setName("Residential Building Insurance");
//        residentialBuildingPackage.setDescription("Residential Building Insurance");
//        residentialBuildingPackage = productRepository.save(residentialBuildingPackage);
//
//        Product commercialBuildingPackage = new Product();
//        commercialBuildingPackage.setActive(true);
//        commercialBuildingPackage.setName("Commercial Building Insurance");
//        commercialBuildingPackage.setDescription("Commercial Building Insurance");
//        commercialBuildingPackage = productRepository.save(commercialBuildingPackage);
//
//        Product travelPackage = new Product();
//        travelPackage.setActive(true);
//        travelPackage.setName("Travel Insurance");
//        travelPackage.setDescription("Travel Insurance");
//        travelPackage = productRepository.save(travelPackage);

        PaymentMethod p1 = new PaymentMethod("Ecocash", "Ecocash");
        if (!paymentMethodExists("Ecocash"))
            paymentMethodRepository.save(p1);

        PaymentMethod p2 = new PaymentMethod("Telecash", "Telecash");
        if (!paymentMethodExists("Telecash"))
            paymentMethodRepository.save(p2);

        PaymentMethod p3 = new PaymentMethod("OneMoney", "OneMoney");
        if (!paymentMethodExists("OneMoney"))
            paymentMethodRepository.save(p3);

        Currency zwl = new Currency();
        zwl.setCode("ZWL");
        zwl.setName("Zimbabwean Dollar");
        if (!currencyExists("ZWL"))
            currencyRepository.save(zwl);

        Currency usd = new Currency();
        usd.setCode("USD");
        usd.setName("United States Dollar");
        if (!currencyExists("USD"))
            currencyRepository.save(usd);

        Currency zar = new Currency();
        zar.setCode("ZAR");
        zar.setName("South African Rand");
        if (!currencyExists("ZAR"))
            currencyRepository.save(zar);

        //  fileUploadUtils.createVehicleTypes(fileUploadUtils.getCSVFileFromClasspath("motorVehicleTypes.csv", "Motor Vehicle Types Upload.csv"));
        //  fileUploadUtils.createCities(fileUploadUtils.getCSVFileFromClasspath("cities-zim.csv", "Zimbabwe Cities and Provinces.csv"));
    }

    boolean productTypeExists(String name) {
        return productTypeRepository.findByNameIgnoreCase(name).isPresent();
    }

    boolean productExists(String name) {
        return productRepository.findByNameIgnoreCase(name).isPresent();
    }

    boolean paymentMethodExists(String name) {
        return paymentMethodRepository.findByNameIgnoreCase(name).isPresent();
    }

    boolean currencyExists(String currencyCode) {
        return currencyRepository.findByCodeIgnoreCase(currencyCode).isPresent();
    }


}