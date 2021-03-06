/* 
 *  Copyright (C) 2004 Thorsten Kamann
 *
 *  File :               UnixUserProcessor.java
 *  Description :       Retrieves a list of the current users
 *  Author's email :     thorsten.kamann@planetes.de
 *  Author's Website :   http://www.izforge.com
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

package com.izforge.izpack.util;

import com.izforge.izpack.panels.ProcessingClient;
import com.izforge.izpack.panels.Processor;
import com.izforge.izpack.util.os.unix.UnixUsers;

/**
 * @author thorsten-kamann
 */
public class UnixUserProcessor implements Processor
{
    
    
    /**
     * Overridden Method returns a list of users in the /etc/passwd
     */
    public String process(ProcessingClient client)
    {
        return UnixUsers.getUsersColonString();
    }
    


}
