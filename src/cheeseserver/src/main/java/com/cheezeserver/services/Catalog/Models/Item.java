package com.cheezeserver.services.Catalog.Models;

import java.util.List;

public record Item(
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
