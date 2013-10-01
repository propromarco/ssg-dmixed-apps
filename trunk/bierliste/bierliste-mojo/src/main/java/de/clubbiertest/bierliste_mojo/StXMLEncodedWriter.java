/* Copyright, (c) 2012 Suretec GmbH  */

package de.clubbiertest.bierliste_mojo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class StXMLEncodedWriter extends Writer
{
    public static final String UTF_8 = "UTF-8";
    private final Writer writer;

    public StXMLEncodedWriter( final OutputStream delegate )
    {
        this.writer = new OutputStreamWriter(delegate);
    }

    public void close()
            throws IOException
    {
        this.writer.close();
    }

    public void flush()
            throws IOException
    {
        this.writer.flush();
    }

    public void write( final char[] cbuf, final int off, final int len )
            throws IOException
    {
        for ( int i = 0; i < len; i++ )
        {
            final char c = cbuf[off + i];
            if (( c >= 0 ) && ( c <= 128 ))
            {
                this.writer.write(c);
            }
            else
            {
                final String weiter = "&#" + ( (int) c ) + ";";
                this.writer.write(weiter);
            }
        }
    }
}
