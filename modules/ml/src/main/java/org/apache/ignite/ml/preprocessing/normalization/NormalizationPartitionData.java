/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.ml.preprocessing.normalization;

/**
 * Partition data used in normalization preprocessor.
 *
 * @see NormalizationTrainer
 * @see NormalizationPreprocessor
 */
public class NormalizationPartitionData implements AutoCloseable {
    /** Minimal values. */
    private final double[] min;

    /** Maximum values. */
    private final double[] max;

    /**
     * Constructs a new instance of normalization partition data.
     *
     * @param min Minimal values.
     * @param max Maximum values.
     */
    public NormalizationPartitionData(double[] min, double[] max) {
        this.min = min;
        this.max = max;
    }

    /** */
    public double[] getMin() {
        return min;
    }

    /** */
    public double[] getMax() {
        return max;
    }

    /** */
    @Override public void close() {
        // Do nothing, GC will clean up.
    }
}
