package net.fettlol.utilmod.registry;

import net.fettlol.utilmod.api.FunctionImpl;
import net.minecraft.util.Identifier;

public class FunctionApi {
    public static void remove(Identifier functionId) {
        FunctionImpl.blockedFunctions.add(functionId);
    }
}
