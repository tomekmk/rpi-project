//package pl.coderslab.config.converters;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//import pl.coderslab.dal.repositories.PinRepo;
//import pl.coderslab.domain.devices.UsedPins;
//
//@Component
//public class PinConverter implements Converter<String, UsedPins> {
//
//    @Override
//    public UsedPins convert(String pin) {
//        UsedPins usedPins = new UsedPins();
//        usedPins.setPinNumber(Integer.parseInt(pin));
//        return usedPins;
//    }
//}