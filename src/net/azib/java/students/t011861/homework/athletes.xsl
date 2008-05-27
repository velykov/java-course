<?xml version="1.0"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 

    <xsl:template match="/athletes"> 
        <HTML> 
            <HEAD> 
                <TITLE> 
                    Decathlon Results 
                </TITLE> 
            </HEAD> 
            <BODY> 
                <H1> 
                    The Decathlon Results 
                </H1> 
                <TABLE BORDER="2"> 
                    <TR> 
                        <TD>Name</TD> 
                        <TD>Date of birth</TD> 
                        <TD>Country</TD> 
                        <TD>Results</TD> 
			<TD>Points</TD>
			<TD>Place</TD>
                    </TR> 
                    <xsl:apply-templates/> 
                </TABLE> 
            </BODY> 
        </HTML> 
    </xsl:template> 

    <xsl:template match="athlete"> 
       <TR> 
          <TD><xsl:value-of select="name"/></TD> 
          <TD><xsl:value-of select="date"/></TD> 
          <TD><xsl:value-of select="country"/></TD> 
          <TD><xsl:value-of select="results"/></TD> 
	  <TD><xsl:value-of select="points"/></TD> 
	  <TD><xsl:value-of select="place"/></TD> 
       </TR> 
    </xsl:template> 

</xsl:stylesheet>