package com.cheezeserver.TestData.Entities;

import java.util.List;

public record Cheese(
    String id,
    String name,
    String description,
    String type,
    String country,
    List<String> milk,
    List<String> texture,
    String colour,
    Double pricePerKilo,
    String imagePath)
{
}