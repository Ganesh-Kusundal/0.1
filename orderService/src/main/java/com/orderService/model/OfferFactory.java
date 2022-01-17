package com.orderService.model;

import java.security.InvalidParameterException;

public class OfferFactory {
    public static IOffer getOfferInstance(String offerName) {
        if (offerName.equalsIgnoreCase("ByOneGetOneFree"))
            return new ByOneGetOneOffer();
        if (offerName.equalsIgnoreCase("ByTwoGetOneFree"))
            return new ByTwoGetOneOffer();
        else
            throw new InvalidParameterException("Offer is invalid.");
    }
}
