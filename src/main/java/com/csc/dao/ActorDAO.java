package com.csc.dao;

import com.csc.models.Actor;

public interface ActorDAO {

	public void insert(Actor actor);
	public Actor findByActorId(int actorId);
}
