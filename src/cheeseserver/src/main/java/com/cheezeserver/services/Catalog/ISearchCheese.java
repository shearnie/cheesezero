package com.cheezeserver.services.Catalog;

import org.springframework.stereotype.Component;

import com.cheezeserver.services.Catalog.Models.Item;
import com.cheezeserver.services.Catalog.Models.ListingResponse;

@Component
public interface ISearchCheese
{
    Item GetById(String id);
    ListingResponse Query(String query);
    ListingResponse GetByType(String type);
    ListingResponse GetByCountry(String type);
    ListingResponse GetByMilk(String type);
    ListingResponse GetByTexture(String type);
    ListingResponse GetByColour(String type);
}
