// 
// Decompiled by Procyon v0.5.30
// 

package com.jiam365.flow.server.dao;

import org.mongodb.morphia.Datastore;
import com.jiam365.flow.server.entity.Bulletin;
import org.mongodb.morphia.dao.BasicDAO;

public class BulletinDao extends BasicDAO<Bulletin, String>
{
    public BulletinDao(final Datastore ds) {
        super(ds);
    }
}
