package aethereal;

import ai.catboost.CatBoostError;
import ai.catboost.CatBoostModel;
import ai.catboost.CatBoostPredictions;
import java.io.IOException;
import java.io.InputStream;

public final class NeuralRotationModel {
   private static final String field0715 = "/models/yaw.cbm";
   private static final String field0136 = "/models/pitch.cbm";
   private static final String[] field1536 = new String[0];
   private static CatBoostModel field1024;
   private static CatBoostModel field0788;
   private static boolean field1276;
   private static boolean field0343;

   private NeuralRotationModel() {
   }

   public static boolean method0579() {
      if (field1276) {
         return field0343;
      }

      field1276 = true;

      try (
         InputStream var0 = NeuralRotationModel.class.getResourceAsStream("/models/yaw.cbm");
         InputStream var1 = NeuralRotationModel.class.getResourceAsStream("/models/pitch.cbm");
      ) {
         if (var0 == null || var1 == null) {
            return false;
         }

         field1024 = CatBoostModel.loadModel(var0);
         field0788 = CatBoostModel.loadModel(var1);
         field0343 = true;
      } catch (CatBoostError | IOException | RuntimeException var8) {
         field0343 = false;
      }

      return field0343;
   }

   public static double method1578(float[] var0) {
      try {
         CatBoostPredictions var1 = field1024.predict(var0, field1536);
         return var1.get(0, 0);
      } catch (CatBoostError | RuntimeException var2) {
         return 0.0;
      }
   }

   public static double method0348(float[] var0) {
      try {
         CatBoostPredictions var1 = field0788.predict(var0, field1536);
         return var1.get(0, 0);
      } catch (CatBoostError | RuntimeException var2) {
         return 0.0;
      }
   }

   public static boolean method0026() {
      return field0343;
   }
}
