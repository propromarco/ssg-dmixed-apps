<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" encoding="utf-8" />
  <xsl:strip-space elements="*" />
  <xsl:include href="tmp.xsl" />
  <xsl:template match="* | @* | text()">
    <xsl:copy>
      <xsl:apply-templates select="* | @* | text()" />
    </xsl:copy>
  </xsl:template>
  <xsl:template match="land">
    <xsl:copy>
      <xsl:attribute name="sort">
        <xsl:value-of select="translate(@name,'öäüÖÄÜ','oauOAU')" />
      </xsl:attribute>
      <xsl:apply-templates select="* | @* | text()" />
    </xsl:copy>
  </xsl:template>
  <xsl:template match="land[@name = 'D']">
    <xsl:copy>
      <xsl:attribute name="sort">Deutschland</xsl:attribute>
      <xsl:attribute name="name">Deutschland</xsl:attribute>
      <xsl:apply-templates />
    </xsl:copy>
  </xsl:template>
  <xsl:template match="land[@name = 'Dom-Rep']">
    <xsl:copy>
      <xsl:attribute name="sort">Dominikanische Republik</xsl:attribute>
      <xsl:attribute name="name">Dominikanische Republik</xsl:attribute>
      <xsl:apply-templates />
    </xsl:copy>
  </xsl:template>
  <xsl:template match="sorte[@name = 'Ex-Lag.']">
    <xsl:copy>
      <xsl:attribute name="name">Export oder Lager</xsl:attribute>
      <xsl:apply-templates />
    </xsl:copy>
  </xsl:template>
  <xsl:template match="sorte[@name = 'Mix']">
    <xsl:copy>
      <xsl:attribute name="name">Biermischgetränke</xsl:attribute>
      <xsl:apply-templates />
    </xsl:copy>
  </xsl:template>
  <xsl:template match="sorte[@name = 'Dunkles']">
    <xsl:copy>
      <xsl:attribute name="name">Dunkles oder Schwarzes</xsl:attribute>
      <xsl:apply-templates />
    </xsl:copy>
  </xsl:template>
  <xsl:template match="liste">
    <xsl:call-template name="CHECKUP" />
    <xsl:copy>
      <xsl:call-template name="Kontinente" />
    </xsl:copy>
  </xsl:template>
  <xsl:template match="land/Bier">
    <xsl:element name="bier">
      <xsl:attribute name="name">
        <xsl:value-of select="@name" />
      </xsl:attribute>
      <xsl:attribute name="note">
        <xsl:value-of select="@note" />
      </xsl:attribute>
      <xsl:attribute name="design">
        <xsl:value-of select="@design" />
      </xsl:attribute>
    </xsl:element>
  </xsl:template>
  <xsl:template match="sorte/Bier">
    <xsl:element name="bier">
      <xsl:attribute name="name">
        <xsl:value-of select="@name" />
      </xsl:attribute>
      <xsl:attribute name="note">
        <xsl:value-of select="translate(@note , ',', '.')" />
      </xsl:attribute>
      <xsl:attribute name="design">
        <xsl:value-of select="translate(@design , ',', '.')" />
      </xsl:attribute>
    </xsl:element>
  </xsl:template>
</xsl:stylesheet>