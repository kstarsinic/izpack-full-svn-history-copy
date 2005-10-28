/*
 * Created on Apr 19, 2005
 * 
 * $Id: DirectoryFilter.java Feb 8, 2004 izpack-frontend
 * Copyright (C) 2005 Andy Gombos
 * 
 * File : DirectoryFilter.java 
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

package izpack.frontend.controller.filters;

import izpack.frontend.view.IzPackFrame;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * @author Andy Gombos
 */
public class DirectoryFilter extends FileFilter
{

    /* (non-Javadoc)
     * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
     */
    public boolean accept(File f)
    {
        return f.isDirectory();
    }

    /* (non-Javadoc)
     * @see javax.swing.filechooser.FileFilter#getDescription()
     */
    public String getDescription()
    {        
        return IzPackFrame.getInstance().langResources().getText("UI.FileFilters.Dir.Desc");
    }

}
