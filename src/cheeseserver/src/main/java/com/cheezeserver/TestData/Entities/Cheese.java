package com.cheezeserver.TestData.Entities;

import java.util.List;

public record Cheese(
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