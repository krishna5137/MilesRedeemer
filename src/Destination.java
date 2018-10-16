/************************************************************
 *                                                          *
 *  CSCI 470/680          Assignment 4         Summer 2017  *                                             
 *  Team 4                                                  *
 *  Programmers: Vaishnavi Paladugu, Krishna Nallamilli     *
 *  Team Leader: Vaishnavi Paladugu                         *
 *  Date Due:   07/21/2017                                  *
 *  Purpose:    This program is find the best flights to    *
 *              to redeem frequent flyer miles on for a     *
 *              traveler.                                   *
 ***********************************************************/
public class Destination {
	private String name;
	private int normalmiles,flycheapmiles,additionalmiles,smonth,emonth;
	  Destination(String n,int nmiles,int fmiles, int amiles, int sm, int em)
	  {
	    setName(n);
	    setNmiles(nmiles);
	    setFmiles(fmiles);
	    setAmiles(amiles);
	    setSmonth(sm);
	    setEmonth(em);
	  }
	  public void setName(String n)
	  {
	    this.name=n;
	  }   
	  public void setNmiles(int nm)
	  {
	    this.normalmiles=nm;
	  }
	  public void setFmiles(int fm)
	  {
	    this.flycheapmiles=fm;
	  }
	   public void setAmiles(int am)
	  {
	    this.additionalmiles=am;
	  }
	  public void setSmonth(int s)
	  {
	    this.smonth=s;
	  }
	  public void setEmonth(int e)
	  {
	    this.emonth=e;
	  }
	  public String getName()
	  {
	    return name;
	  }
	  public int getNormalMiles( )
	  {
	    return normalmiles;
	  }
	   public int getFlyCheapMiles()
	  {
	    return flycheapmiles;
	  }
	   public int getAdditionalMiles()
	  {
	    return additionalmiles;
	  }
	  public int getSmonth( )
	  {
	    return smonth;
	  }
	   public int getEmonth()
	  {
	    return emonth;
	  }
}
