/*
 * Created on Aug 29, 2005
 * 
 * $Id: PreviouslyConfigured.java Feb 8, 2004 izpack-frontend
 * Copyright (C) 2001-2003 IzPack Development Group
 * 
 * File : PreviouslyConfigured.java 
 * Description : TODO Add description
 * Author's email : gumbo@users.berlios.de
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package izpack.frontend.view.stages.configure.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PreviouslyConfigured extends JPanel implements ConfigurePanel
{
    public PreviouslyConfigured()
    {
        add(new JLabel("This panel was previously configured. Make any changes there."));
    }
    
    public Element createXML(Document doc)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void initFromXML(Document xmlFile)
    {
        // TODO Auto-generated method stub

    }

}
