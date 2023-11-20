package net.fettlol.utilmod.api;

import net.minecraft.util.Identifier;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FunctionImpl {
    public static final Set<Identifier> blockedFunctions = ConcurrentHashMap.newKeySet();
}
