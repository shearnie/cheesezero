package com.cheezeserver.services.Catalog.Models;

import java.util.List;

public record Item(
    String Id,
    String Name,
    String Description,
    String Type,
    String Country,
    List<String> Milk,
    List<String> Texture,
    String Colour,
    Double PricePerKilo,
    String ImagePath)
{
}
