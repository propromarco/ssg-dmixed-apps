<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" encoding="utf-8" indent="yes" />
  <xsl:strip-space elements="*" />
  <xsl:template match="kontinente">
    <xsl:element name="xsl:stylesheet">
      <xsl:attribute name="version">1.0</xsl:attribute>
      <xsl:element name="xsl:template">
        <xsl:attribute name="name">Kontinente</xsl:attribute>
	<xsl:apply-templates />
      </xsl:element>
      <xsl:element name="xsl:template">
        <xsl:attribute name="name">CHECKUP</xsl:attribute>
	<xsl:element name="xsl:for-each">
	  <xsl:attribute name="select">//land</xsl:attribute>
	  <xsl:element name="xsl:choose">
	    <xsl:for-each select="//land">
	      <xsl:element name="xsl:when">
	        <xsl:attribute name="test">
		  <xsl:text>@name = '</xsl:text>
		  <xsl:value-of select="@name" />
		  <xsl:text>'</xsl:text>
		</xsl:attribute>
	      </xsl:element>
	    </xsl:for-each>
	    <xsl:element name="xsl:otherwise">
	      <xsl:element name="xsl:message">
	        <xsl:element name="xsl:text"># Kein Kontinenteintrag für '</xsl:element>
		<xsl:element name="xsl:value-of">
		  <xsl:attribute name="select">@name</xsl:attribute>
		</xsl:element>
		<xsl:element name="xsl:text">'</xsl:element>
	      </xsl:element>
	    </xsl:element>
	  </xsl:element>
	</xsl:element>
      </xsl:element>
    </xsl:element>
  </xsl:template>
  <xsl:template match="kontinent">
    <xsl:element name="xsl:element">
      <xsl:attribute name="name">kontinent</xsl:attribute>
      <xsl:element name="xsl:attribute">
        <xsl:attribute name="name">name</xsl:attribute>
	<xsl:value-of select="@name" />
      </xsl:element>
      <xsl:apply-templates />
    </xsl:element>
  </xsl:template>
  <xsl:template match="land">
    <xsl:element name="xsl:apply-templates">
      <xsl:attribute name="select">
        <xsl:text>land[@name = '</xsl:text>
	<xsl:value-of select="@name" />
	<xsl:text>']</xsl:text>
      </xsl:attribute>
    </xsl:element>
  </xsl:template>
</xsl:stylesheet>