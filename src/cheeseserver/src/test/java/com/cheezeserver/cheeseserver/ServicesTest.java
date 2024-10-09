package com.cheezeserver.cheeseserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cheezeserver.services.Catalog.ISearchCheese;
import com.cheezeserver.services.Catalog.SearchCheeseMock;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ServicesTest {

    private ISearchCheese searchCheese;
	
	public ServicesTest()
	{
		searchCheese = new SearchCheeseMock();
	}

	@Test
	public void ByType_Empty()
	{
		var rs = searchCheese.GetByType("");
		assertThat(rs.Items().size()).isEqualTo(12);
	}

	@Test
	public void ByType_Bogus()
	{
		var rs = searchCheese.GetByType("moon rocks");
		assertThat(rs.Items().size()).isEqualTo(0);
	}

	@Test
	public void ByType_FreshSoft()
	{
		var rs = searchCheese.GetByType("fresh-soft");
		assertThat(rs.Items().size()).isEqualTo(3);

		rs = searchCheese.GetByType("fresh soft");
		assertThat(rs.Items().size()).isEqualTo(3);
	}

	@Test
	public void ByCountry_England()
	{
		var rs = searchCheese.GetByCountry("england");
		assertThat(rs.Items().size()).isEqualTo(2);
	}

	@Test
	public void ByMilk_Cow()
	{
		var rs = searchCheese.GetByMilk("cow");
		assertThat(rs.Items().size()).isEqualTo(9);
	}

	@Test
	public void ByTexture_Stringy()
	{
		var rs = searchCheese.GetByTexture("stringy");
		assertThat(rs.Items().size()).isEqualTo(1);
	}

	@Test
	public void ByColour_BrownishYellow()
	{
		var rs = searchCheese.GetByColour("brownish yellow");
		assertThat(rs.Items().size()).isEqualTo(3);
	}
}
