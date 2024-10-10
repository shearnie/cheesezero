package com.cheezeserver.services.Catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cheezeserver.TestData.Entities.Cheese;
import com.cheezeserver.TestData.Entities.Cheeses;
import com.cheezeserver.services.Catalog.Models.Item;
import com.cheezeserver.services.Catalog.Models.ListingResponse;

import io.micrometer.common.util.StringUtils;

@Service
public class SearchCheeseMock implements ISearchCheese
{
    private List<Item> Map(List<Cheese> source)
    {
        var ret = new ArrayList<Item>();
        for (Cheese cheese: source)
        {
            ret.add(new Item(cheese.Id(), cheese.Name(), cheese.Description(), cheese.Type(), cheese.Country(), cheese.Milk(), cheese.Texture(), cheese.Colour(), cheese.PricePerKilo(), cheese.ImagePath()));
        }
        return ret;
    }
    
    public Item GetById(String id)
    {        
        var db = new Cheeses();

        if (StringUtils.isEmpty(id))
        {
            return new Item("", "", "", "", "", Arrays.asList(), Arrays.asList(), "", 0.0, "");
        }
        
        var rs = db.Data.stream()
            .filter(i -> i.Id().equalsIgnoreCase(id))
            .collect(Collectors.toList());

        if (rs.size() == 0)
        {
            return new Item("", "", "", "", "", Arrays.asList(), Arrays.asList(), "", 0.0, "");
        }

        return Map(rs).get(0);
    }

    public ListingResponse Query(String query)
    {        
        var db = new Cheeses();

        if (StringUtils.isEmpty(query))
        {
            return new ListingResponse(Map(db.Data));
        }
        
        var rs = db.Data.stream()
            .filter(i -> i.Name().toLowerCase().contains(query.toLowerCase()))
            .collect(Collectors.toList());

        return new ListingResponse(Map(rs));
    }

    public ListingResponse GetByType(String type)
    {
        var db = new Cheeses();

        if (StringUtils.isEmpty(type))
        {
            return new ListingResponse(Map(db.Data));
        }

        var rs = db.Data.stream()
            .filter(i -> i.Type().equalsIgnoreCase(type.replace("-", " ")))
            .collect(Collectors.toList());

        return new ListingResponse(Map(rs));
    }
    
    public ListingResponse GetByCountry(String country)
    {
        var db = new Cheeses();

        if (StringUtils.isEmpty(country))
        {
            return new ListingResponse(Map(db.Data));
        }

        var rs = db.Data.stream()
            .filter(i -> i.Country().equalsIgnoreCase(country.replace("-", " ")))
            .collect(Collectors.toList());

        return new ListingResponse(Map(rs));
    }

    public ListingResponse GetByMilk(String milk)
    {
        var db = new Cheeses();

        if (StringUtils.isEmpty(milk))
        {
            return new ListingResponse(Map(db.Data));
        }

        var rs = db.Data.stream()
            .filter(i -> {
                    var matchingTexture = i.Milk().stream()
                        .filter(t -> t.equalsIgnoreCase(milk.replace("-", " ")));
                    return matchingTexture.count() > 0;
                })
            .collect(Collectors.toList());

        return new ListingResponse(Map(rs));
    }
    
    public ListingResponse GetByTexture(String texture)
    {
        var db = new Cheeses();

        if (StringUtils.isEmpty(texture))
        {
            return new ListingResponse(Map(db.Data));
        }

        var rs = db.Data.stream()
            .filter(i -> {
                    var matchingTexture = i.Texture().stream()
                        .filter(t -> t.equalsIgnoreCase(texture.replace("-", " ")));
                    return matchingTexture.count() > 0;
                })
            .collect(Collectors.toList());

        return new ListingResponse(Map(rs));
    }
    
    public ListingResponse GetByColour(String colour)
    {
        var db = new Cheeses();

        if (StringUtils.isEmpty(colour))
        {
            return new ListingResponse(Map(db.Data));
        }

        var rs = db.Data.stream()
            .filter(i -> i.Colour().equalsIgnoreCase(colour.replace("-", " ")))
            .collect(Collectors.toList());

        return new ListingResponse(Map(rs));
    }
}
