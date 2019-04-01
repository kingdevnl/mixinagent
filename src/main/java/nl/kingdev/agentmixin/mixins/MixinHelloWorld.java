package nl.kingdev.agentmixin.mixins;


import hackme.HackMe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = HackMe.class, remap = false)
public abstract class MixinHelloWorld {

    @Shadow public static HackMe instance;



    @Inject(cancellable = true, method = "main", at = @At(value = "INVOKE", target = "Lhackme/HackMe;toHook()V", shift = At.Shift.BEFORE))
    private static void main(String[] args, CallbackInfo c) {
        System.out.println("Before");
    }

    /**
     * @author Jasper
     */
    @Overwrite
    public void toHook() {
        System.out.println("HOOKED! "+instance.toString());
    }
}
