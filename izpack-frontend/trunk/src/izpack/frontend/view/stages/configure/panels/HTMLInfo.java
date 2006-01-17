/*
 * Created on Jan 17, 2006
 * 
 * $Id: HTMLInfo.java Feb 8, 2004 izpack-frontend
 * Copyright (C) 2005 Andy Gombos
 * 
 * File : HTMLInfo.java 
 * Description : TODO Add description
 * Author's email : gumbo@users.berlios.de
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package izpack.frontend.view.stages.configure.panels;

import izpack.frontend.view.components.HTMLEditor;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import utils.IO;
import utils.UI;

/** Implement the information panel.  This allows the user to select or create
 * a README type file - plain text that is
 * 
 * @author Andy Gombos
 */
public class HTMLInfo extends FileEdit
{
    public HTMLInfo()
    {   
        super();
        
        editor = new HTMLEditor();        
                
        setTextEditor(editor);
    }
    
    @Override
    protected void updateEditorDisplay(String filename)
    {
        try
        {
            editor.loadDocument(filename);
        }
        catch (IOException ioe)        
        {
            UI.showError(ioe.getLocalizedMessage(), "IO error");
        }
        catch (BadLocationException e)
        {
            //Ignore, I don't think this can happen
        }
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
    
    private HTMLEditor editor;
}
