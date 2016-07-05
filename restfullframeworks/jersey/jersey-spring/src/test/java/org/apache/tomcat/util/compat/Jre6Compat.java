/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tomcat.util.compat;

public class Jre6Compat extends JreCompat {

    protected static final Class<?> sslParametersClass;
    
    static {
        Class<?> c = null;
        try {
            c = Class.forName("javax.net.ssl.SSLParameters");
        } catch (SecurityException e) {
            // Should never happen
        } catch (ClassNotFoundException e) {
            // Expected on Java 5
        }
        sslParametersClass = c;
    }

    static boolean isSupported() {
        return sslParametersClass != null;
    }
}
