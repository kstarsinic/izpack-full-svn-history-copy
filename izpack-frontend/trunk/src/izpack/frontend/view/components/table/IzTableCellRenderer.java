/*
 * Created on Apr 11, 2005
 * 
 * $Id: IzTableCellRenderer.java Feb 8, 2004 izpack-frontend
 * Copyright (C) 2005 Andy Gombos
 * 
 * File : IzTableCellRenderer.java 
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

package izpack.frontend.view.components.table;

import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.TableCellRenderer;

/**
 * @author Andy Gombos
 */
public interface IzTableCellRenderer extends TableCellRenderer
{
    public abstract int getHeight();
    
    Border selected = new SoftBevelBorder(SoftBevelBorder.RAISED);
}