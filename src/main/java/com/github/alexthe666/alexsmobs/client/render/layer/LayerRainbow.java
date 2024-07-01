package com.github.alexthe666.alexsmobs.client.render.layer;

import com.github.alexthe666.alexsmobs.client.render.AMRenderTypes;
import com.github.alexthe666.alexsmobs.entity.util.RainbowUtil;
import com.github.alexthe666.alexsmobs.item.ItemRainbowJelly;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class LayerRainbow extends RenderLayer {

    private RenderLayerParent parent;

    public LayerRainbow(RenderLayerParent parent) {
        super(parent);
        this.parent = parent;
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        int i = RainbowUtil.getRainbowType((LivingEntity)entity);
        if(entity instanceof LivingEntity && i > 0) {
            ItemRainbowJelly.RainbowType rainbowType = ItemRainbowJelly.RainbowType.values()[Mth.clamp(i - 1, 0,ItemRainbowJelly.RainbowType.values().length - 1)];
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(getRenderType(rainbowType));
            float alpha = 0.5F;
            matrixStackIn.pushPose();
            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, LivingEntityRenderer.getOverlayCoords((LivingEntity)entity, 0), 1, 1, 1, alpha);
            matrixStackIn.popPose();
        }
    }

    private RenderType getRenderType(ItemRainbowJelly.RainbowType rainbowType) {
        return switch (rainbowType) {
            case TRANS -> AMRenderTypes.TRANS_GLINT;
            case NONBI -> AMRenderTypes.NONBI_GLINT;
            case BI -> AMRenderTypes.BI_GLINT;
            case ACE -> AMRenderTypes.ACE_GLINT;
            case WEEZER -> AMRenderTypes.WEEZER_GLINT;
            case BRAZIL -> AMRenderTypes.BRAZIL_GLINT;
            case CHINA -> AMRenderTypes.CHINA_GLINT;
            case COOLCAT -> AMRenderTypes.COOLCAT_GLINT;
            case GOJO -> AMRenderTypes.GOJO_GLINT;
            case LOBA -> AMRenderTypes.LOBA_GLINT;
            case MARIO -> AMRenderTypes.MARIO_GLINT;
            case PUPPY -> AMRenderTypes.PUPPY_GLINT;
            case RACCOON -> AMRenderTypes.RACCOON_GLINT;
            case SOYJACK -> AMRenderTypes.SOYJACK_GLINT;
            case TROLL -> AMRenderTypes.TROLL_GLINT;
            case JOOMFACE -> AMRenderTypes.JOOMFACE_GLINT;
            case ROBERT -> AMRenderTypes.ROBERT_GLINT;
            case SKULL -> AMRenderTypes.SKULL_GLINT;
            case FRIEREN -> AMRenderTypes.FRIEREN_GLINT;
            case BLACK -> AMRenderTypes.BLACK_GLINT;
            case BLUE -> AMRenderTypes.BLUE_GLINT;
            case BROWN -> AMRenderTypes.BROWN_GLINT;
            case CYAN -> AMRenderTypes.CYAN_GLINT;
            case GRAY -> AMRenderTypes.GRAY_GLINT;
            case GREEN -> AMRenderTypes.GREEN_GLINT;
            case INDIGO -> AMRenderTypes.INDIGO_GLINT;
            case MAGENTA -> AMRenderTypes.MAGENTA_GLINT;
            case OLDYELLOW -> AMRenderTypes.OLDYELLOW_GLINT;
            case ORANGE -> AMRenderTypes.ORANGE_GLINT;
            case PALEGREEN -> AMRenderTypes.PALEGREEN_GLINT;
            case PINK -> AMRenderTypes.PINK_GLINT;
            case PURPLE -> AMRenderTypes.PURPLE_GLINT;
            case RED -> AMRenderTypes.RED_GLINT;
            case REDANDGOLD -> AMRenderTypes.REDANDGOLD_GLINT;
            case SKYBLUE -> AMRenderTypes.SKYBLUE_GLINT;
            case SPRINKLES -> AMRenderTypes.SPRINKLES_GLINT;
            case WHITE -> AMRenderTypes.WHITE_GLINT;
            case YELLOW -> AMRenderTypes.YELLOW_GLINT;
            default -> AMRenderTypes.RAINBOW_GLINT;
        };
    }
}
