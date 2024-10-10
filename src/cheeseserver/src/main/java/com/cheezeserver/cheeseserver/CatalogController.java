package com.cheezeserver.cheeseserver;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cheezeserver.services.Catalog.ISearchCheese;
import com.cheezeserver.services.Catalog.SearchCheeseMock;
import com.cheezeserver.services.Catalog.Models.Item;
import com.cheezeserver.services.Catalog.Models.ListingResponse;

@RestController
@RequestMapping("/catalog")
public class CatalogController
{
    // TODO dependency injection doesn't make sense to me in Java
    // @Autowired
    private ISearchCheese searchCheese;

    public CatalogController()
    {
        searchCheese = new SearchCheeseMock();
    }

    @CrossOrigin
    @RequestMapping(value="details", method = RequestMethod.GET)
    public Item Details(@RequestParam("id") String id)
    {
        return searchCheese.GetById(id);
    }

    // TODO pagination on these methods.
    
    @CrossOrigin
    @RequestMapping(value="query", method = RequestMethod.GET)
    public ListingResponse Query(@RequestParam("q") String q)
    {
        return searchCheese.Query(q);
    }

    @CrossOrigin
    @GetMapping("/bytype")
    public ListingResponse GetByType()
    {
        return searchCheese.GetByType("");
    }

    @CrossOrigin
    @GetMapping("/bytype/{type}")
    public ListingResponse GetByType(@PathVariable String type)
    {
        return searchCheese.GetByType(type);
    }
}
