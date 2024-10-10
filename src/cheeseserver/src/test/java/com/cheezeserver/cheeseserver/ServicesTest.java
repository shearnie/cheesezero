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
	public void Search_Blank()
	{
		var rs = searchCheese.Query("");
		assertThat(rs.Items().size()).isEqualTo(12);
	}

	@Test
	public void Search_Blue()
	{
		var rs = searchCheese.Query("blue");
		assertThat(rs.Items().size()).isEqualTo(3);
	}

	@Test
	public void GetById_Blank()
	{
		var rs = searchCheese.GetById("");
		assertThat(rs.Id()).isEqualTo("");
	}

	@Test
	public void GetById_Bogus()
	{
		var rs = searchCheese.GetById("blahblah");
		assertThat(rs.Id()).isEqualTo("");
	}

	@Test
	public void GetById_Valid()
	{
		var rs = searchCheese.GetById("42cec8b8-f350-4ce8-a60c-8220df2b4e57");
		assertThat(rs.Id()).isEqualTo("42cec8b8-f350-4ce8-a60c-8220df2b4e57");
		assertThat(rs.Name()).isEqualTo("Roaring Forties Blue");
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
