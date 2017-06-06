/***********************************************************************
 * Copyright (c) 2013-2017 Commonwealth Computer Research, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License, Version 2.0
 * which accompanies this distribution and is available at
 * http://www.opensource.org/licenses/apache2.0.php.
 ***********************************************************************/

package org.locationtech.geomesa.fs.storage.api;

import org.geotools.data.Query;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import java.util.Iterator;
import java.util.List;

public interface FileSystemStorage {
    List<SimpleFeatureType> listFeatureTypes();
    SimpleFeatureType getFeatureType(String name);

    void createNewFeatureType(SimpleFeatureType sft);

    Iterator<SimpleFeature> getReader(Query q, String partition);
    List<String> listPartitions(String typeName);

    FileSystemWriter getWriter(String typeName, String partition);
}